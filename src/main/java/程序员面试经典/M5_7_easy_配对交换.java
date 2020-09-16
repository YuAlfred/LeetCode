package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/16 9:58 上午
 * @description : 面试题 05.07. 配对交换
 * @modified By  :
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * 示例2:
 * <p>
 * 输入：num = 3
 * 输出：3
 * 提示:
 * <p>
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exchange-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M5_7_easy_配对交换 {


    public int exchangeBits(int num) {
        char[] a = Integer.toBinaryString(num).toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (a.length % 2 == 1) {
            sb.append(a[0]);
            sb.append("0");
            i++;
        }
        for (; i < a.length - 1; i += 2) {
            sb.append(a[i + 1]);
            sb.append(a[i]);
        }
        return Integer.parseInt(sb.toString(),2);
    }

}
