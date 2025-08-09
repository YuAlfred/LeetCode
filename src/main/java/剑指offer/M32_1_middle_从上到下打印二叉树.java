package 剑指offer;


import java.util.*;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/4 19:26
 * @description : 剑指 Offer 32 - I. 从上到下打印二叉树
 * @modified By  :
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M32_1_middle_从上到下打印二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode temp = new TreeNode(20);
        temp.left = new TreeNode(15);
        temp.right = new TreeNode(7);
        root.right = temp;
        levelOrder2(root);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();

    }

    public static int[] levelOrder2(TreeNode root) {
        if (root == null)
            return new int[0];
        List<TreeNode> list = new ArrayList<>();
        int i = 0;
        list.add(root);
        while (i < list.size()) {
            TreeNode mid = list.get(i);
            if (mid.left != null)
                list.add(mid.left);
            if (mid.right != null)
                list.add(mid.right);
            i++;
        }
        //stream性能比for慢五倍左右
//        int[] res = list.stream().map(treeNode -> treeNode.val).mapToInt(Integer::valueOf).toArray();
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k).val;
        }
        return res;

    }


}





