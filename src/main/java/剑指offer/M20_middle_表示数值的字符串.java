package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/31 23:35
 * @description : 剑指 Offer 20. 表示数值的字符串
 * @modified By  :
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * <p>
 *  
 * <p>
 * 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M20_middle_表示数值的字符串 {

    public static void main(String[] args) {
        double a = 1e+5;
        System.out.println(isNumber("46.e3"));
    }


    public static boolean isNumber(String s) {

        if (s == null || s.isEmpty()) {
            return false;
        }

        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] cs = s.trim().toCharArray();

        for (int i = 0; i < cs.length; i++) {
            //是数字
            if (cs[i] >= '0' && cs[i] <= '9') {
                numSeen = true;
            } else if (cs[i] == '.') {
                //如果是.
                //.之前不能出现.或e
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (cs[i] == 'e' || cs[i] == 'E') {
                //如果是e
                //e之前不能出现e，e之前必须有数字
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                //充值numseen 确保e之后还必须出现数
                numSeen = false;
            } else if (cs[i] == '+' || cs[i] == '-') {
                //如果是-或+
                //必须在第一个字符或者e之后第一个字符
                if (i != 0 && cs[i - 1] != 'e' && cs[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }


}
