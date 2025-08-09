package 每日打卡;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/9/26 2:50
 * @description : 371. 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：a = 2, b = 3
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * -1000 <= a, b <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M371_middle_两整数之和 {

    public int getSum(int a, int b) {

        while (b != 0) {
            int c = ((a & b) << 1);
            a ^= b;
            b = c;
        }
        return a;
    }


}
