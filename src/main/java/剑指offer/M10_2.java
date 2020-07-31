package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/25 18:01
 * @description : 剑指 Offer 10- II. 青蛙跳台阶问题
 * @modified By  :
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M10_2 {

    public static void main(String[] args) {
        M10_2 m10_2 = new M10_2();
        System.out.println(m10_2.numWays(7));
    }


    public int numWays(int n) {

        int[] nums = new int[101];
        nums[0] = 1;
        nums[1] = 1;
        return getNums(nums, n);

    }

    public int getNums(int[] nums, int n) {
        if (n < 0) {
            return 0;
        }
        if (nums[n] != 0) {
            return nums[n];
        }
        nums[n] = (int) ((getNums(nums, n - 1) + getNums(nums, n - 2)) % (1e9 + 7));
        return nums[n];

    }

}






