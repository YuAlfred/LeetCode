package 剑指offer;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/8/24 5:19 下午
 * @description : 剑指 Offer 56 - I. 数组中数字出现的次数
 * @modified By  :
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M56_1_middle_数组中数字出现的次数 {


    public static void main(String[] args) {
        singleNumbers(new int[]{2, 1, 5, 2});
    }

    public static int[] singleNumbers(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        int a = 0b1;
        while ((result & a) == 0) {
            a <<= 1;
        }
        int n1 = 0, n2 = 0;
        for (int i : nums) {
            if ((i & a) == 0) {
                n1 ^= i;
            } else {
                n2 ^= i;
            }
        }
        return new int[]{n1, n2};
    }


}











