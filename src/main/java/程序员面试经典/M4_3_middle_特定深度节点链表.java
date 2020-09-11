package 程序员面试经典;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/11 10:05 上午
 * @description : 面试题 04.03. 特定深度节点链表 给
 * @modified By  :
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_3_middle_特定深度节点链表 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ListNode head = new ListNode(0);
            ListNode cur = head;
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                cur.next = new ListNode(temp.val);
                cur = cur.next;
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
            res.add(head.next);
        }
        return res.toArray(new ListNode[res.size()]);
    }
}
