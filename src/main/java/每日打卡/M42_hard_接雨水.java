package 每日打卡;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/28 6:33 下午
 * @description : 42. 接雨水
 * @modified By  :
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M42_hard_接雨水 {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int low = Math.min(height[l], height[r]);
        int ans = 0;
        while (l < r) {
            while (l < r && height[l] <= height[r]) {
                if (height[l] < low) {
                    ans += low - height[l];
                }else {
                    low = height[l];
                }
                l++;
            }
            while (l < r && height[l] > height[r]) {
                if (height[r] < low) {
                    ans += low - height[r];
                }else {
                    low = height[r];
                }
                r--;
            }
        }
        return ans;
    }



    /*public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l++];
            } else {
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r--];
            }
        }
        return res;
    }*/
}



















