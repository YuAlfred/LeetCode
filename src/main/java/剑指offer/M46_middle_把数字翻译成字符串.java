package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/18 17:35
 * @description : 剑指 Offer 46. 把数字翻译成字符串
 * @modified By  :
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M46_middle_把数字翻译成字符串 {

    public static void main(String[] args) {
        translateNum(506);
    }

    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1, res = 1;
        char pre = s.charAt(0);
        for (int i = 2; i <= s.length(); i++) {
            if (pre == '1' || (pre == '2' && s.charAt(i - 1) <= '5')) {
                res = a + b;
            } else {
                res = b;
            }
            a = b;
            b = res;
            pre = s.charAt(i - 1);
        }
        return res;
    }
}











