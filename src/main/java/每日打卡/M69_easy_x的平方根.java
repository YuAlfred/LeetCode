package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 69. x 的平方根
 * @date: 2021/4/8 10:06 上午
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M69_easy_x的平方根 {


    public int mySqrt(int x) {

        int l = 1, r = x;

        while (l <= r) {
            int middle = l + ((r - l) >> 1);
            long m2 = (long) middle * middle;
            if (m2 > x) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return r;
    }


}
