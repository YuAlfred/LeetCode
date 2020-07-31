package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/26 13:45
 * @description : 剑指 Offer 13. 机器人的运动范围
 * @modified By  :
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M13 {

    public static void main(String[] args) {
        M13 m13 = new M13();
        System.out.println(m13.movingCount(3, 2, 17));
    }

    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return getCount(m, n, k, 0, 0);

    }

    public int getCount(int m, int n, int k, int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n || splitSum(i, j) > k || visited[i][j] == true) {
            return 0;
        }
        visited[i][j] = true;
        return getCount(m, n, k, i + 1, j) + getCount(m, n, k, i, j + 1) + 1;
    }

    public int splitSum(int m, int n) {

        String sM = String.valueOf(m);
        String sN = String.valueOf(n);

        int result = 0;
        for (char i : sM.toCharArray()) {
            result += (i - '0');
        }
        for (char i : sN.toCharArray()) {
            result += (i - '0');
        }
        return result;
    }


}




