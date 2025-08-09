package 每日打卡;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 851. 喧闹和富有
 * @date: 2021/12/15 3:37 PM
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
 * <p>
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 * <p>
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
 * 最安静（有较低安静值 quiet[x]）的人是 person 7。
 * 其他的答案也可以用类似的推理来解释。
 * 示例 2：
 * <p>
 * 输入：richer = [], quiet = [0]
 * 输出：[0]
 *  
 * 提示：
 * <p>
 * n == quiet.length
 * 1 <= n <= 500
 * 0 <= quiet[i] < n
 * quiet 的所有值 互不相同
 * 0 <= richer.length <= n * (n - 1) / 2
 * 0 <= ai, bi < n
 * ai != bi
 * richer 中的所有数对 互不相同
 * 对 richer 的观察在逻辑上是一致的
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/loud-and-rich
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M851_middle_喧闹和富有 {

    public static void main(String[] args) {
        M851_middle_喧闹和富有 m = new M851_middle_喧闹和富有();
        m.loudAndRich(new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}}, new int[]{3, 2, 5, 4, 6, 1, 7, 0});
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<Integer>[] parents = new List[quiet.length];
        int[] ans = new int[quiet.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int[] pair : richer) {
            if (parents[pair[1]] == null) {
                parents[pair[1]] = new LinkedList<>();
            }
            parents[pair[1]].add(pair[0]);
        }
        for (int i = 0; i < quiet.length; i++) {
            getQuietest(parents, quiet, ans, i);
        }
        return ans;
    }

    public int getQuietest(List<Integer>[] parents, int[] quiet, int[] ans, int i) {
        // 如果已经找到了 就直接返回
        if (ans[i] != Integer.MAX_VALUE) {
            return ans[i];
        }
        // 如果没父亲节点，最安静的人就是他自己
        if (parents[i] == null) {
            ans[i] = i;
            return i;
        }
        // 如果有父亲节点，依次比较父亲节点的最安静和自己 找到最安静的人
        ans[i] = i;
        for (Integer man : parents[i]) {
            int ansParent = getQuietest(parents, quiet, ans, man);
            ans[i] = quiet[ans[i]] < quiet[ansParent] ? ans[i] : ansParent;
        }
        return ans[i];
    }


}
