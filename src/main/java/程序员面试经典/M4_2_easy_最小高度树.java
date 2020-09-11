package 程序员面试经典;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/11 9:38 上午
 * @description : 面试题 04.02. 最小高度树
 * @modified By  :
 * <p>
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M4_2_easy_最小高度树 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums);
        return rec(nums, 0, nums.length - 1);
    }

    public TreeNode rec(int[] nums, int begin, int end) {
        if (end - begin < 0) {
            return null;
        }
        if (end - begin == 0) {
            return new TreeNode(nums[begin]);
        }
        int mid = (begin + end) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = rec(nums, begin, mid - 1);
        res.right = rec(nums, mid + 1, end);
        return res;
    }


}













