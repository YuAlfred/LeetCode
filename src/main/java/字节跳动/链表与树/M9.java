package 字节跳动.链表与树;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/21 1:07
 * @description : 二叉树的锯齿形层次遍历
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1027/
 * @modified By  :
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class M9 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.right = new TreeNode(15);
        right.left = new TreeNode(7);

        new M9().zigzagLevelOrder(root);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        if (root==null){
            return result;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.add(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {


            List<Integer> temp = new LinkedList<>();

            if (s1.isEmpty()){
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if (node.right != null) {
                        s1.push(node.right);
                    }
                    if (node.left != null) {
                        s1.push(node.left);
                    }
                }
            }else {
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    temp.add(node.val);
                    if (node.left != null) {
                        s2.push(node.left);
                    }
                    if (node.right != null) {
                        s2.push(node.right);
                    }
                }
            }

            result.add(temp);
        }

        return result;
    }

}
