//package 每日打卡;
//
//import sun.applet.AppletClassLoader;
//
///**
// * @author alfredt
// * @version 1.0.0
// * @description: 526. 优美的排列
// * @date: 2021/8/16 12:31 上午
// * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
// * <p>
// * 第 i 位的数字能被 i 整除
// * i 能被第 i 位上的数字整除
// * 现在给定一个整数 N，请问可以构造多少个优美的排列？
// * <p>
// * 示例1:
// * <p>
// * 输入: 2
// * 输出: 2
// * 解释:
// * <p>
// * 第 1 个优美的排列是 [1, 2]:
// * 第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
// * 第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
// * <p>
// * 第 2 个优美的排列是 [2, 1]:
// * 第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
// * 第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
// * 说明:
// * <p>
// * N 是一个正整数，并且不会超过15。
// * <p>
// * <p>
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/beautiful-arrangement
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//public class M526_middle_优美的排列 {
//
//    public static void main(String[] args) {
//    }
//
//    int ans = 0;
//
//    public int countArrangement(int n) {
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = i + 1;
//        }
//        dfs(nums, 0);
//        return ans;
//    }
//
//    public void dfs(int[] nums, int index) {
//        int n = nums.length;
//        if (index >= n) {
//            ans++;
//            return;
//        }
//        for (int i = index; i < n; i++) {
//            swap(nums, index, i);
//            if (isLegal(index + 1, nums[index])) {
//                dfs(nums, index + 1);
//            }
//            swap(nums, index, i);
//        }
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//
//    public boolean isLegal(int i, int numI) {
//        return i % numI == 0 || numI % i == 0;
//    }
//
//}
