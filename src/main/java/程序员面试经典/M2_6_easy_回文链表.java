package 程序员面试经典;


/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/9 2:50 下午
 * @description : 面试题 02.06. 回文链表
 * @modified By  :
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 *  
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M2_6_easy_回文链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // public boolean isPalindrome(ListNode head) {
    //     //找中点
    //     ListNode slow = head, fast = head;
    //     while (fast.next != null && fast.next.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     ListNode rightHead = slow.next;
    //     ListNode pre = null, next = rightHead.next;
    //     while (rightHead != null) {
    //        rightHead.next = pre;
    //
    //     }
    //
    //
    // }


}
