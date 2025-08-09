package 程序员面试经典;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/9/19 12:57
 * @description : 面试题 05.03. 翻转数位
 * @modified By  :
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M5_3_easy_翻转数位 {

    public static void main(String[] args) {
        reverseBits(2147483647);
    }

    public static int reverseBits(int num) {
        String s = Integer.toBinaryString(num);
        if (s.length() < 32) {
            s = "0" + s;
        }
        int max = 0, temp = 0, p = -1, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                temp++;
                if (temp > max) {
                    max = temp;
                }
            } else {
                if (p == -1) {
                    p = i;
                    temp++;
                    if (temp > max) {
                        max = temp;
                    }
                } else {
                    temp -= (p - start);
                    start = p + 1;
                    p = i;
                }
            }
        }
        return max;
    }
}
















