package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/16 9:35 上午
 * @description : 05.06. 整数转换
 * @modified By  :
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * 示例2:
 * <p>
 * 输入：A = 1，B = 2
 * 输出：2
 * 提示:
 * <p>
 * A，B范围在[-2147483648, 2147483647]之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-integer-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M5_6_easy_整数转换 {

    public int convertInteger(int A, int B) {
        String sA = Integer.toBinaryString(A);
        String sB = Integer.toBinaryString(B);
        int diff = 0;
        int i = sA.length() - 1;
        int j = sB.length() - 1;
        while (i >= 0 && j >= 0) {
            if (sA.charAt(i) != sB.charAt(j)) {
                diff++;
            }
            i--;
            j--;
        }
        while (i>=0){
            if (sA.charAt(i)=='1'){
                diff++;
            }
            i--;
        }
        while (j>=0){
            if (sB.charAt(j)=='1'){
                diff++;
            }
            j--;
        }
        return diff;
    }

}
