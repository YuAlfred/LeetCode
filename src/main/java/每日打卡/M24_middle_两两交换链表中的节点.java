package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 24. 两两交换链表中的节点
 * @date: 2020/10/13 6:16 下午
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M24_middle_两两交换链表中的节点 {


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

    public ListNode swapPairs(ListNode head) {

        ListNode p = new ListNode();
        p.next = head;
        ListNode pre = p;
        ListNode cur = head;
        while (pre.next != null && cur.next != null && cur.next.next != null) {
            pre.next = cur.next;
            pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return p.next;
    }

}
