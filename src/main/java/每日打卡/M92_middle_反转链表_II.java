package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 92. 反转链表 II
 * @date: 2021/3/18 9:14 上午
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M92_middle_反转链表_II {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;

        ListNode mPre = fakeHead;
        ListNode n = fakeHead;
        int count = 1;
        while (count < left) {
            mPre = mPre.next;
            n = n.next;
            count++;
        }
        while (count <= right) {
            n = n.next;
            count++;
        }

        //反转
        ListNode pre = n.next;
        ListNode cur = mPre.next;
        while (cur != n) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        cur.next = pre;
        mPre.next = cur;

        return fakeHead.next;
    }


}
