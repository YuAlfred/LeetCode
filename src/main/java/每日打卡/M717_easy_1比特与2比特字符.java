package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 717. 1比特与2比特字符
 * @date: 2021/4/6 10:23 上午
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * <p>
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 * <p>
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * 注意:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M717_easy_1比特与2比特字符 {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (n < 2 || bits[n - 2] == 0) {
            return true;
        }
        int cur = 0;
        while (cur < n - 2) {
            if (bits[cur] == 0) {
                cur++;
            } else {
                cur += 2;
            }
        }
        return cur == n - 1;
    }


}
