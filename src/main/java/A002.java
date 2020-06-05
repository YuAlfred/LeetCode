/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/6/1 20:46
 * @description : 2. 两数相加
 * @modified By  :
 */
public class A002 {

    public static void main(String[] args) {
        System.out.println(1 / 10);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p;
        int inc;

        int sum = p1.val + p2.val;
        root = new ListNode(sum % 10);
        inc = sum / 10;
        p = root;
        p1 = p1.next;
        p2 = p2.next;

        while (p1 != null || p2 != null || inc != 0) {
            sum = inc;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(sum % 10);
            inc = sum / 10;

            p = p.next;
        }
        return root;
    }

}


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}