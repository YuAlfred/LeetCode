package 每日打卡;


import java.util.*;
import java.util.stream.Stream;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 987. 二叉树的垂序遍历
 * @date: 2021/7/31 9:55 上午
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 * 1 在上面，所以它出现在前面。
 * 5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M987_hard_二叉树的垂序遍历 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();

        Map<Integer, List<int[]>> map = new HashMap<>();
        dfs(map, root, 0, 0);

        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        for (Integer key : keys) {
            List<int[]> list = map.get(key);
            List<Integer> temp = new LinkedList<>();
            Collections.sort(list, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
            list.forEach(p -> temp.add(p[0]));
            ans.add(temp);
        }
        return ans;
    }


    public void dfs(Map<Integer, List<int[]>> map, TreeNode root, int bios, int level) {
        if (root == null) {
            return;
        }
        List list = map.getOrDefault(bios, new LinkedList<>());
        int[] cur = new int[2];
        cur[0] = root.val;
        cur[1] = level;
        list.add(cur);
        map.put(bios, list);
        dfs(map, root.left, bios - 1, level + 1);
        dfs(map, root.right, bios + 1, level + 1);
    }
}
