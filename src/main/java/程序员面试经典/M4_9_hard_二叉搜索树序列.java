package 程序员面试经典;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/9/12 17:12
 * @description : 面试题 04.09. 二叉搜索树序列
 * @modified By  :
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * 给定如下二叉树
 * <p>
 * 2
 * / \
 * 1   3
 * 返回：
 * <p>
 * [
 * [2,1,3],
 * [2,3,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bst-sequences-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_9_hard_二叉搜索树序列 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        List<TreeNode> items = new LinkedList<>();
        if (root != null) {
            items.add(root);
        }
        recur(res, path, items);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> path, List<TreeNode> items) {
        if (items.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        int len = items.size();
        for (int i = 0; i < len; i++) {
            TreeNode node = items.get(i);
            path.add(node.val);
            items.remove(i);
            if (node.left != null) {
                items.add(node.left);
            }
            if (node.right != null) {
                items.add(node.right);
            }
            recur(res, path, items);
            path.remove(path.size() - 1);
            items.add(i, node);
            items.remove(node.left);
            items.remove(node.right);
        }
    }


}
