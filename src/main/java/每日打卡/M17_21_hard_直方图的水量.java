package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.21. 直方图的水量
 * @date: 2021/4/2 9:32 上午
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_21_hard_直方图的水量 {


    public int trap(int[] height) {

        if (height.length <= 2) {
            return 0;
        }

        int curLeft = 0;
        int curRight = height.length - 1;

        int leftHeight = height[0];
        int rightHeight = height[curRight];

        int ans = 0;

        while (curLeft < curRight) {
            while (curLeft < curRight && leftHeight < rightHeight) {
                if (height[curLeft] < leftHeight) {
                    ans += (leftHeight - height[curLeft]);
                }
                curLeft++;
                leftHeight = Math.max(leftHeight, height[curLeft]);
            }
            while (curLeft < curRight && leftHeight >= rightHeight) {
                if (height[curRight] < rightHeight) {
                    ans += (rightHeight - height[curRight]);
                }
                curRight--;
                rightHeight = Math.max(rightHeight, height[curRight]);
            }
        }

        return ans;
    }


}
