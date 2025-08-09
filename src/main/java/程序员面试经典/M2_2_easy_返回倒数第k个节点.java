package 程序员面试经典;

import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/9 2:32 下午
 * @description : 面试题 02.02. 返回倒数第 k 个节点
 * @modified By  :
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M2_2_easy_返回倒数第k个节点 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int kthToLast(ListNode head, int k) {
        ListNode i = head, j = head;
        for (int l = 0; l < k; l++) {
            j = j.next;
        }
        while (j!=null){
            i = i.next;
            j = j.next;
        }
        return i.val;
    }


}










