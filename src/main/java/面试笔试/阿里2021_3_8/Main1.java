package 面试笔试.阿里2021_3_8;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/8 6:22 下午
 *
 * 共m个任务n个工人，每个任务需要a个工人，产出b的利润，问在使用不超过最大工人数的情况下满足最小利润p的方案总数
 */
public class Main1 {

    static int mod = (int) (1e9 + 7);

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            //任务数
            int m = in.nextInt();
            // 最多工人数
            int n = in.nextInt();
            // 最少利润
            int p = in.nextInt();
            //工人数量
            int[] a = new int[m];
            // 利润
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = in.nextInt();
            }

            long[] res = new long[1];
            res[0] = 0;
            dfs(m, a, b, n, p, 0, res);
            System.out.println((int) res[0]);
        }
        in.close();
    }

    public static void dfs(int m, int[] a, int[] b, int n, int p, int index, long[] res) {
        if (index >= m || n <= 0) {
            return;
        }
        //不选
        dfs(m, a, b, n, p, index + 1, res);

        //选
        if (a[index] <= n) {
            p -= b[index];
            if (p <= 0) {
                res[0]++;
                res[0] %= mod;
            }
            dfs(m, a, b, n - a[index], p, index + 1, res);
        }
    }

}
