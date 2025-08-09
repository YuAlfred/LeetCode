package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 2:38 下午
 * @description : 面试题 08.05. 递归乘法
 * @modified By  :
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * 提示:
 * <p>
 * 保证乘法范围不会溢出
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recursive-mulitply-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_5_middle_递归乘法 {


    public int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        }
        return multiply(A, B - 1) + A;
    }

}
