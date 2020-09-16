package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/15 5:25 下午
 * @description : 面试题 05.02. 二进制数转字符串
 * @modified By  :
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>
 * 示例1:
 * <p>
 * 输入：0.625
 * 输出："0.101"
 * 示例2:
 * <p>
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * 提示：
 * <p>
 * 32位包括输出中的"0."这两位。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bianry-number-to-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M5_2_middle_二进制数转字符串 {

    public String printBin(double num) {
        double res = 0;
        double d = 1;
        StringBuilder sb = new StringBuilder();
        boolean hasRes = false;
        for (int i = 0; i < 30; i++) {
            d *= 2;
            double temp = 1 / d;
            if (num > temp) {
                num -= temp;
                sb.append("1");
            } else if (num < temp) {
                sb.append("0");
            } else {
                sb.append("1");
                hasRes = true;
                break;
            }
        }
        if (hasRes) {
            return sb.insert(0, "0.").toString();
        } else {
            return "ERROR";
        }

    }
}









