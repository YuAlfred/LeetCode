package 面试笔试.野村证券2022_4_16;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2022/4/16 13:03
 */
public class Main3 {

    public static void main(String[] args) {
        Main3 main1 = new Main3();
        System.out.println(main1.solution(new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2}));
    }

    public int solution(int[] A) {
        dfs(A, 0, A.length - 1, 0);
        return ans;
    }

    public int ans = 0;

    public void dfs(int[] A, int start, int end, int curHeight) {
        if (start > end || start < 0 || end >= A.length) {
            return;
        }
        int minHeight = Integer.MAX_VALUE;
        int minPoint = start;
        for (int i = start; i <= end; i++) {
            if (minHeight > A[i]) {
                minHeight = A[i];
                minPoint = i;
            }
        }
        ans += (minHeight - curHeight);
        dfs(A, start, minPoint - 1, minHeight);
        dfs(A, minPoint + 1, end, minHeight);
    }

}
