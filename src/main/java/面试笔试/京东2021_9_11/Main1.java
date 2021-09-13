package 面试笔试.京东2021_9_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/11 6:02 下午
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                map.put(c, new int[]{i, j});
            }
        }
        String target = in.next();
        in.close();

        int curX = 0;
        int curY = 0;
        long ans = 0;

        for (char c : target.toCharArray()) {
            int oneTime = 0;
            int[] targetCharPosition = map.get(c);
            // 先算xy轴移动的时间
            oneTime += Math.abs(targetCharPosition[0] - curX) * x;
            oneTime += Math.abs(targetCharPosition[1] - curY) * x;
            // 转向的时间
            if (targetCharPosition[0] != curX && targetCharPosition[1] != curY) {
                oneTime += y;
            }
            // 点击的时间
            oneTime += z;
            ans += oneTime;
            // 更改当前爪子位置
            curX = targetCharPosition[0];
            curY = targetCharPosition[1];
        }

        System.out.println(ans);
    }

}
