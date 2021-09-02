package 剑指offer;

import java.util.Map;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/3 15:42
 * @description : 剑指 Offer 22. 链表中倒数第k个节点
 * @modified By  :
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M22_easy_链表中倒数第k个节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode getKthFromEnd2(ListNode head, int k) {

        ListNode front = head;
        ListNode end = head;

        for (int i = 0; i < k; i++) {
            end = end.next;
        }

        while (end != null) {
            front = front.next;
            end = end.next;
        }
        return front;

    }


    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode cur = head;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        while (cur != null) {
            cur = cur.next;
            head = head.next;
        }
        return head;
    }


}





