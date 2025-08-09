package 剑指offer;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/4 12:36 上午
 * @description : 剑指 Offer 61. 扑克牌中的顺子
 * @modified By  :
 * <p>
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5 
 * <p>
 * 数组的数取值为 [0, 13] .
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M61_easy_扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeros = 0;
        while (nums[zeros] == 0) {
            zeros++;
        }
        for (int i = zeros; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        if (nums[4] - nums[zeros] > 4) {
            return false;
        }
        return true;
    }
}















