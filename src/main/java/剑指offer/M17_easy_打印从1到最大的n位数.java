package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/27 13:12
 * @description : 剑指 Offer 17. 打印从1到最大的n位数
 * @modified By  :
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_easy_打印从1到最大的n位数 {

    public static int[] printNumbers(int n) {
        String s = "";
        while (n > 0) {
            s += "9";
            n--;
        }
        int scope = Integer.valueOf(s);
        int[] res = new int[scope];
        for (int i = 0; i < scope; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
