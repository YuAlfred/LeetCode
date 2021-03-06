package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 978. 最长湍流子数组
 * @date: 2021/2/8 9:15 上午
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M978_middle_最长湍流子数组 {

    /*public int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        int max = 1;
        int tempMax = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((i & 1) == 1) {
                if (arr[i] > arr[i + 1]) {
                    tempMax++;
                    max = Math.max(tempMax, max);
                } else {
                    tempMax = 1;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    tempMax++;
                    max = Math.max(tempMax, max);
                } else {
                    tempMax = 1;
                }
            }
        }
        tempMax = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((i & 1) == 1) {
                if (arr[i] < arr[i + 1]) {
                    tempMax++;
                    max = Math.max(tempMax, max);
                } else {
                    tempMax = 1;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    tempMax++;
                    max = Math.max(tempMax, max);
                } else {
                    tempMax = 1;
                }
            }
        }
        return max;
    }*/

    /*
     * 解法二，动态规划
     * */
    public int maxTurbulenceSize(int[] arr) {

        if (arr.length <= 1) {
            return arr.length;
        }
        int[][] dp = new int[arr.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            if (arr[i] > arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i] < arr[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dp[i][0]);
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

}
