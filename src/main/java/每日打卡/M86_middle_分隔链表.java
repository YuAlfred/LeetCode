package 每日打卡;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/1/3 14:20
 * @description : 86. 分隔链表
 * @modified By  :
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M86_middle_分隔链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode curSmall = small;
        ListNode large = new ListNode(0);
        ListNode curLarge = large;
        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                head = head.next;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                head = head.next;
                curLarge = curLarge.next;
            }
        }
        curLarge.next = null;
        curSmall.next = large.next;
        return small.next;
    }
}
