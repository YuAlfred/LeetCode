/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/4/21 3:21 下午
 * @description : 1248.统计[优美子数]
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * @modified By  :
 */
public class MS1248 {

    public static void main(String[] args) {
        MS1248 m = new MS1248();
        System.out.println(m.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int[] numsI = new int[nums.length + 1];
        numsI[0] = 1;
        int count = 0, odds = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                odds++;
            }
            if (odds >= k) {
                count += numsI[odds - k];
            }
            numsI[odds] += 1;
        }
        return count;
    }

}
