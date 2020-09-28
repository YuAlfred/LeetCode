package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/27 11:44 下午
 * @description : 面试题 17.21. 直方图的水量
 * @modified By  :
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

    public static void main(String[] args) {
        trap(new int[]{4, 2, 3});
    }


    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                res += lMax - height[l++];
                lMax = Math.max(lMax, height[l]);
            } else {
                res += rMax - height[r--];
                rMax = Math.max(rMax, height[r]);
            }
        }
        return res;
    }
}










