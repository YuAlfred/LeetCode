package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/8 23:26
 * @description : 剑指 Offer 37. 序列化二叉树
 * @modified By  :
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M37_hard_序列化二叉树 {

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // TreeNode right = new TreeNode(3);
        // right.left = new TreeNode(4);
        // right.right = new TreeNode(5);
        // root.right = right;
        //
        // TreeNode rs = deserialize(serialize(root));
        // System.out.println();
        Codec m = new Codec();
        m.deserialize("1,2,3,null,null,4,5");

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        dfs(root, sb);
        return sb.toString();
    }

    public static void dfs(TreeNode node, StringBuffer sb) {
        if (node == null) {
            sb.append("null,");
            return;
        } else {
            sb.append(node.val + ",");
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.isEmpty() || data.equals("null,")) {
            return null;
        }
        serializedData = data.split(",");
        return backDfs();
    }

    public static String[] serializedData;
    public static int i = 0;

    public static TreeNode backDfs() {
        if (i >= serializedData.length) {
            return null;
        }
        String sVal = serializedData[i];
        i++;
        if (sVal.equals("null")) {
            return null;
        }
        int val = Integer.parseInt(sVal);
        TreeNode res = new TreeNode(val);
        res.left = backDfs();
        res.right = backDfs();
        return res;
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    sb.append(",");
                    if (cur != null) {
                        sb.append(cur.val);
                        queue.add(cur.left);
                        queue.add(cur.right);
                    } else {
                        sb.append("null");
                    }
                }
            }
            return sb.deleteCharAt(0).toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            String[] datas = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
            int index = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (datas[index].equals("null")) {
                        cur.left = null;
                    } else {
                        TreeNode left = new TreeNode(Integer.parseInt(datas[index]));
                        cur.left = left;
                        queue.add(left);
                    }
                    index++;
                    if (datas[index].equals("null")) {
                        cur.right = null;
                    } else {
                        TreeNode right = new TreeNode(Integer.parseInt(datas[index]));
                        cur.right = right;
                        queue.add(right);
                    }
                    index++;
                }
            }
            return root;
        }
    }
}














