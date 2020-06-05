/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/4/11 7:01 下午
 * @description : 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * @modified By  :
 */
public class MS887 {

    public static void main(String[] args) {
        MS887 m = new MS887();
        System.out.println(m.superEggDrop(2, 9));
    }

    int[][] steps;

    public int superEggDrop(int K, int N) {
        steps = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                steps[i][j] = -1;
            }
        }
        return dp(K, N);
    }

    public int dp(int K, int N) {
        int res;
        if (steps[K][N] == -1) {
            if (N == 0) {
                res = 0;
            } else if (K == 1) {
                res = N;
            } else {
                int low = 1;
                int high = N;
                while (low + 1 < high) {
                    int mid = (low + high) / 2;
                    int left = dp(K - 1, mid - 1);
                    int right = dp(K, N - mid);

                    if (left < right) {
                        low = mid;
                    } else if (left > right) {
                        high = mid;
                    } else {
                        low = high = mid;
                    }
                }
                res = 1 + Math.min(
                        Math.max(dp(K - 1, low - 1), dp(K, N - low)),
                        Math.max(dp(K - 1, high - 1), dp(K, N - high)));
            }
            steps[K][N] = res;
        }
        return steps[K][N];
    }

}
