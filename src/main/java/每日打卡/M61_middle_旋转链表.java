package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 61. 旋转链表
 * @date: 2021/3/28 5:04 下午
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M61_middle_旋转链表 {

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

    public ListNode rotateRight(ListNode head, int k) {

        int length = 0;
        ListNode count = head;
        while (count != null) {
            length++;
            count = count.next;
        }
        if (length==0){
            return head;
        }
        k = k % length;

        ListNode breakpoint = head;
        ListNode tail = head;

        for (int i = 0; i < k - 1; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            tail = tail.next;
            breakpoint = breakpoint.next;
        }
        tail.next = head;
        head = breakpoint.next;
        breakpoint.next = null;
        return head;
    }
}
