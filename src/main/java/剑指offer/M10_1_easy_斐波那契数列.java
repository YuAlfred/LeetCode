package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/25 17:49
 * @description : 剑指 Offer 10- I. 斐波那契数列
 * @modified By  :
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M10_1_easy_斐波那契数列 {


    public static void main(String[] args) {
        M10_1_easy_斐波那契数列 m10 = new M10_1_easy_斐波那契数列();
        System.out.println(m10.fib(100));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int pre = 0;
        int cur = 1;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = (int) ((pre + cur) % (1e9 + 7));
            pre = cur;
            cur = sum;
        }

        return sum;

    }

}





