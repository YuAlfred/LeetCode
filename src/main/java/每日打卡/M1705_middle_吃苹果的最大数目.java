package 每日打卡;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : Alfred.T
 * @version : 1.0.0
 * @date : Created in 2021/12/24 23:05
 * @description : 1705. 吃苹果的最大数目
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 * <p>
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * <p>
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * 示例 2：
 * <p>
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 *  
 * <p>
 * 提示：
 * <p>
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1705_middle_吃苹果的最大数目 {

    public static void main(String[] args) {
        M1705_middle_吃苹果的最大数目 m = new M1705_middle_吃苹果的最大数目();
        m.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2});
    }

    public int eatenApples(int[] apples, int[] days) {
        // 每批次苹果按照最早过期时间排序
        PriorityQueue<Apples> queuedApples = new PriorityQueue<>(Comparator.comparingInt(o -> o.day));
        int n = apples.length;
        int curDay = 0;
        int ans = 0;
        // 先一天天边吃边长
        while (curDay < n) {
            // 先长今天的
            queuedApples.add(new Apples(apples[curDay], days[curDay] + curDay - 1));
            // 先把过期的苹果或者被吃光的苹果删掉
            while (!queuedApples.isEmpty() && (queuedApples.peek().day < curDay || queuedApples.peek().num == 0)) {
                queuedApples.poll();
            }
            // 如果没可吃的了就下一天
            if (queuedApples.isEmpty()) {
                curDay++;
                continue;
            }
            // 再选一个最近过期的吃掉
            queuedApples.peek().num--;
            ans++;
            curDay++;
        }
        // 最后吃剩下的
        while (true) {
            // 先把过期的苹果或者被吃光的苹果删掉
            while (!queuedApples.isEmpty() && (queuedApples.peek().day < curDay || queuedApples.peek().num == 0)) {
                queuedApples.poll();
            }
            // 如果没可吃的了就结束
            if (queuedApples.isEmpty()) {
                break;
            }
            // 再选一个最近过期的吃掉
            queuedApples.peek().num--;
            ans++;
            curDay++;
        }
        return ans;
    }

    class Apples {
        int num;
        int day;

        public Apples(int num, int day) {
            this.num = num;
            this.day = day;
        }
    }


}
