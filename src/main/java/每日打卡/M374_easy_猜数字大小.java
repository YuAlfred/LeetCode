package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 374. 猜数字大小
 * @date: 2021/4/8 10:19 上午
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：n = 2, pick = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M374_easy_猜数字大小 {

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     */
    int guess(int num) {
        return -1;
    }


    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int middle = (l + (r - l) / 2);
            int res = guess(middle);
            if (res == 0) {
                return middle;
            } else if (res == -1) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return l;
    }


    public int guessNumber2(int n) {

        int l = 1, r = n;
        while (l < r) {
            int m = (l + (r - l)) / 2;
            int g = guess(m);
            if (g == 0) {
                return m;
            } else if (g == 1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

}
