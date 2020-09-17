package 面试笔试.字节跳动.链表与树;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/15 23:26
 * @description : 合并两个有序链表
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1048/
 * @modified By  :
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class M1 {


    class ListNode {
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


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode ln = new ListNode();
        ListNode head = ln;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ln.next = l1;
                ln = ln.next;
                l1 = l1.next;
            } else {
                ln.next = l2;
                ln = ln.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            ln.next = l1;
        }

        if (l2 != null) {
            ln.next = l2;
        }

        head = head.next;

        return head;
    }
}


