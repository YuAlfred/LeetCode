package 字节跳动.链表与树;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/19 22:16
 * @description : 排序链表
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1040/
 * @modified By  :
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class M4 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode head = l1;
        l1.next = new ListNode(5);
        l1 = l1.next;
        l1.next = new ListNode(3);
        l1 = l1.next;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(0);
        l1 = l1.next;

        M4 m4 = new M4();
        m4.sortList(head);

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 归并排序，但是不递归
     * bottom-to-up算法
     * 先两两合并，然后四四合并。。。。
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode sentry = new ListNode(0);
        sentry.next = head;

        /**
         * 计算链表长度
         */
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }


        for (int i = 1; i < length; i <<= 1) {
            ListNode cur = sentry.next;
            ListNode left;
            ListNode right;
            ListNode tail = sentry;

            while (cur != null) {

                left = cur;
                right = cut(cur, i);
                cur = cut(right, i);

                tail.next = merge(left, right);

                while (tail.next != null) {
                    tail = tail.next;
                }

            }

        }

        return sentry.next;

    }

    /**
     * 只保留list的前size个，返回后面部分的链表头
     *
     * @param list
     * @param size
     * @return
     */
    public ListNode cut(ListNode list, int size) {

        if (list == null) {
            return null;
        }

        ListNode pre = list;
        ListNode result = list;
        int i = 0;
        while (i < size && result != null) {
            pre = result;
            result = result.next;
            i++;
        }
        pre.next = null;
        return result;
    }

    /**
     * 合并两个已排序的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode merge(ListNode l1, ListNode l2) {

        ListNode sentry = new ListNode(0);
        ListNode result = sentry;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
                result = result.next;
            } else {
                result.next = l2;
                l2 = l2.next;
                result = result.next;
            }
        }

        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }

        return sentry.next;

    }


}
