package 每日打卡;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 5:05 下午
 * @description : 300. 最长上升子序列
 * @modified By  :
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M300_middle_最长上升子序列 {


    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int[] tail = new int[nums.length];
        for (int num : nums) {
            int i = 0, j = len;
            while (i < j) {
                int m = (i + j) / 2;
                if (tail[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tail[i] = num;
            if (j == len) {
                len++;
            }
        }
        return len;
    }

}
