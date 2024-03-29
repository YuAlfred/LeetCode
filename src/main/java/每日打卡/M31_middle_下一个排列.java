package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 31. 下一个排列
 * @date: 2020/11/10 3:23 下午
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M31_middle_下一个排列 {

    public static void main(String[] args) {
        M31_middle_下一个排列 m = new M31_middle_下一个排列();
        m.nextPermutation(new int[]{3,2,1});
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = nums.length - 2, j = nums.length - 1;
        while (j > 0) {
            if (nums[i] >= nums[j]) {
                i--;
                j--;
            } else {
                int k = nums.length - 1;
                while (nums[i] >= nums[k]) {
                    k--;
                }
                swap(nums, i, k);
                break;
            }
        }
        i = j;
        j = nums.length - 1;
        for (; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
