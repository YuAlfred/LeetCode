import java.util.*;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/9 19:43
 * @description :
 * @modified By  :
 */
public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] pokers = new int[n][2];
        for (int i = 0; i < n; i++) {
            pokers[i][0] = in.nextInt();
            pokers[i][1] = in.nextInt();
        }
        in.close();
        if (n == 0) {
            System.out.println(0);
        }
        Arrays.sort(pokers, (o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[n];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (pokers[i][1] > pokers[j][1]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }

        System.out.println(maxans);
    }

}
