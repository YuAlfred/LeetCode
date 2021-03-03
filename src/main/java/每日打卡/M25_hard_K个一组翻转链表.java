package 每日打卡;

import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 25. K 个一组翻转链表
 * @date: 2021/3/3 3:56 下午
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 * <p>
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 提示：
 * <p>
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M25_hard_K个一组翻转链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode myHead = new ListNode(0);
        myHead.next = head;
        boolean end = false;
        ListNode pre = myHead;
        ListNode cur = head;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    end = true;
                    break;
                }
                cur = cur.next;
            }
            if (end) {
                break;
            }
            pre = reverseK(pre, k);
            pre.next = cur;
        }
        return myHead.next;
    }

    public ListNode reverseK(ListNode pre, int k) {
        ListNode head = pre.next;
        ListNode cur = pre;
        ListNode next = head;
        ListNode next2 = next.next;
        for (int i = 0; i < k - 1; i++) {
            cur = next;
            next = next2;
            next2 = next.next;
            next.next = cur;
        }
        pre.next = next;
        return head;
    }

}
