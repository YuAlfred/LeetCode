package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * @date: 2021/6/1 10:49 下午
 */
public class M1744_middle_你能在你最喜欢的那天吃到你最喜欢的糖果吗 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        int n = candiesCount.length;

        // 前缀和
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];

            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;


    }
}
