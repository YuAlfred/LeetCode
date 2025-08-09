package 剑指offer;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/8 12:12 上午
 * @description : 剑指 Offer 65. 不用加减乘除做加法
 * @modified By  :
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 * <p>
 * 提示：
 * <p>
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M65_easy_不用加减乘除做加法 {

    public int add(int a, int b) {
        while (b != 0) {
            //进位
            int c = (a & b) << 1;
            //非进位和
            a ^= b;
            b = c;
        }
        return a;
    }


}











