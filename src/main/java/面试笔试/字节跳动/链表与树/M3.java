package 面试笔试.字节跳动.链表与树;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/19 15:01
 * @description : 两数相加
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1022/
 * @modified By  :
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class M3 {

    public static void main(String[] args) {
        M3 m3 = new M3();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);

        m3.addTwoNumbers(l1, l2);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode p = result;

        int add = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            l1 = l1.next;
            l2 = l2.next;
            result.next = new ListNode(sum % 10);
            result = result.next;
            add = sum / 10;
        }

        while (l1 != null) {
            int sum = l1.val + add;
            l1 = l1.next;
            result.next = new ListNode(sum % 10);
            result = result.next;
            add = sum / 10;
        }

        while (l2 != null) {
            int sum = l2.val + add;
            l2 = l2.next;
            result.next = new ListNode(sum % 10);
            result = result.next;
            add = sum / 10;
        }

        if (add != 0) {
            result.next = new ListNode(add);
        }


        return p.next;

    }


}



