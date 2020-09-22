package 每日打卡;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/22 5:29 下午
 * @description : 337. 打家劫舍 III
 * @modified By  :
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M337_middle_打家劫舍_III {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 解法1，递归加一个map消除重复，重上至下
     */
    // public Map<TreeNode, Integer> memo = new HashMap<>();
    //
    // public int rob(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     if (memo.containsKey(root)) {
    //         return memo.get(root);
    //     }
    //     int dontRob = rob(root.left) + rob(root.right);
    //     int doRob = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
    //         + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
    //     int res = Math.max(dontRob, doRob);
    //     memo.put(root, res);
    //     return res;
    // }

    /**
     * 解法2 返回一个数组 记录两个信息，从下至上
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        //[0]表示抢当前节点，【1】表示不抢
        int[] arr = new int[2];
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        arr[0] = root.val + l[1] + r[1];
        //不抢，下家可抢可不抢
        arr[1] = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return arr;
    }
}







