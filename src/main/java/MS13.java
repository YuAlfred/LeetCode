/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/4/8 6:33 下午
 * @description : 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * @modified By  :
 */
public class MS13 {

    public boolean[][] touched;
    public int movingStep = 0;

    public static void main(String[] args) {
        MS13 m = new MS13();
        // System.out.println(m.movingCount(2, 3, 1));
        System.out.println(m.getNumCount(2, 33));
        // System.out.println(91 / 100);
    }

    public int movingCount(int m, int n, int k) {
        touched = new boolean[m][n];
        movingStep++;
        recursion(0, 0, m - 1, n - 1, k);
        return movingStep;
    }

    public void recursion(int m, int n, int maxM, int maxN, int k) {
        if (goAble(m, n + 1, maxM, maxN, k)) {
            touched[m][n + 1] = true;
            recursion(m, n + 1, maxM, maxN, k);
            movingStep++;
        }
        if (goAble(m + 1, n, maxM, maxN, k)) {
            touched[m + 1][n] = true;
            recursion(m + 1, n, maxM, maxN, k);
            movingStep++;
        }
    }

    public int getNumCount(int m, int n) {

        return m / 100 + (m % 100) / 10 + m % 10 + n / 100 + (n % 100) / 10 + n % 10;

    }

    public boolean goAble(int m, int n, int maxM, int maxN, int k) {
        return m >= 0 && n >= 0 && getNumCount(m, n) <= k && m <= maxM && n <= maxN && !touched[m][n];
    }
}
