package 程序员面试经典;

import java.util.List;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/9/18 19:48
 * @description : 面试题 02.04. 分割链表
 * @modified By  :
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M2_4_middle_分割链表 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode partition(ListNode head, int x) {
        if (head== null){
            return head;
        }
        ListNode tail = head;
        int size = 0;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.val >= x) {
                if (pre == null) {
                    head = cur.next;
                    tail.next = cur;
                    tail = tail.next;
                    cur = head;
                } else {
                    pre.next = cur.next;
                    tail.next = cur;
                    tail = tail.next;
                    cur = cur.next;
                }
            }else {
                pre= cur;
                cur = cur.next;
            }
        }
        tail.next = null;
        return head;
    }
}


















