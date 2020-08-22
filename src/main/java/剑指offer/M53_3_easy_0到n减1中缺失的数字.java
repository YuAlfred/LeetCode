package 剑指offer;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/8/22 11:25 下午
 * @description : 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @modified By  :
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M53_3_easy_0到n减1中缺失的数字 {

    public int missingNumber(int[] nums) {

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] <= middle) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return i;
    }

}












