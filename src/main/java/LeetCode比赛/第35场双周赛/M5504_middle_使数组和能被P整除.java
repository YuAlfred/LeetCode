package LeetCode比赛.第35场双周赛;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/9/19 22:52
 * @description :
 * @modified By  :
 * 5504. 使数组和能被 P 整除 显示英文描述
 * 通过的用户数59
 * 尝试过的用户数93
 * 用户总通过次数59
 * 用户总提交次数118
 * 题目难度Medium
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 * <p>
 * 请你返回你需要移除的最短子数组，如果无法满足题目要求，返回 -1 。
 * <p>
 * 子数组 定义为原数组中连续的一组元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3], p = 3
 * 输出：0
 * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 * 示例  4：
 * <p>
 * 输入：nums = [1,2,3], p = 7
 * 输出：-1
 * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 * 示例 5：
 * <p>
 * 输入：nums = [1000000000,1000000000,1000000000], p = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 */
public class M5504_middle_使数组和能被P整除 {

    public int minSubarray(int[] nums, int p) {
        long pp  =p;
        int len = nums.length;
        long s[] = new long[len+1];

        for(int i=0;i<len;++i){
            s[i+1] = s[i] + nums[i];
            s[i+1]%= pp;
        }
        long y = s[len]%pp;
        if(y==0) return 0;

        Map<Long,Integer> lst =new HashMap<>();
        lst.put(0L,0);
        int r =len;
        for(int i=1;i<=len;++i){
            long ck = (pp + (s[i]-y)%pp)%pp;
            if(lst.containsKey(ck)){
                r =Math.min(r, i-lst.get(ck));
            }
            lst.put(s[i],i);
        }
        return r==len?-1:r;
    }
}
