package 每日打卡;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 863. 二叉树中所有距离为 K 的结点
 * @date: 2021/7/28 10:29 下午
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * <p>
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M863_middle_二叉树中所有距离为K的结点 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, TreeNode> sunFatherMap = new HashMap<>();
    Set<TreeNode> showed = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> path = new ArrayList<>();

        dfs(root);
        find(root, path, 0, k);
        return path;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            sunFatherMap.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            sunFatherMap.put(root.right, root);
            dfs(root.right);
        }
    }

    public void find(TreeNode root, List<Integer> path, int cur, int k) {
        if (root == null) {
            return;
        }
        showed.add(root);
        if (cur > k) {
            return;
        }
        if (cur == k) {
            path.add(root.val);
        }
        TreeNode parent = sunFatherMap.get(root);
        if (parent != null && !showed.contains(parent)) {
            find(parent, path, cur - 1, k);
        }
        if (null != root.left && !showed.contains(root.left)) {
            find(root.left, path, cur + 1, k);
        }
        if (null != root.right && !showed.contains(root.right)) {
            find(root.right, path, cur + 1, k);
        }
    }

}
