package 每日打卡;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/28 6:38 下午
 * @description : 11. 盛最多水的容器
 * @modified By  :
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M11_middle_盛最多水的容器 {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                res = Math.max(res, (r - l) * height[l]);
                l++;
            } else {
                res = Math.max(res, (r - l) * height[r]);
                r--;
            }
        }
        return res;
    }

}

















