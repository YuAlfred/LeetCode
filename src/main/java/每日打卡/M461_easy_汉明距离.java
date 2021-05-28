package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 461. 汉明距离
 * @date: 2021/5/27 9:15 上午
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M461_easy_汉明距离 {

    public int hammingDistance(int x, int y) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }


}
