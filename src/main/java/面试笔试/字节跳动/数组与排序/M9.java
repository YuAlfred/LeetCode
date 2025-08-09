package 面试笔试.字节跳动.数组与排序;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/15 23:07
 * @description : 接雨水
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1047/
 * @modified By  :
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class M9 {

    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftHeight = 0, rightHeight = 0;
        int result = 0;
        int temp = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftHeight = Math.max(leftHeight, height[left]);
                result += leftHeight - height[left];
                left++;
            } else {
                rightHeight = Math.max(rightHeight, height[right]);
                result += rightHeight - height[right];
                right--;
            }
        }

        return result;

    }

}
