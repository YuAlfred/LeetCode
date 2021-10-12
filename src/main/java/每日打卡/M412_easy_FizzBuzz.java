package 每日打卡;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 412. Fizz Buzz
 * @date: 2021/10/13 12:35 上午
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M412_easy_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        int nextFizz = 3, nextBuzz = 5;
        List<String> ans = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i == nextFizz && i == nextBuzz) {
                ans.add("FizzBuzz");
                nextFizz += 3;
                nextBuzz += 5;
            } else if (i == nextFizz) {
                ans.add("Fizz");
                nextFizz += 3;
            } else if (i == nextBuzz) {
                ans.add("Buzz");
                nextFizz += 5;
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }


}
