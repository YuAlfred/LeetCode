package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 149. 直线上最多的点数
 * @date: 2021/6/24 11:13 下午
 */
public class M149_hard_直线上最多的点数 {


    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                double k = (points[i][0] - points[j][0]) / (double) (points[i][1] - points[j][1]);
                int times = map.getOrDefault(k, 1);
                times++;
                res = Math.max(res, times);
                map.put(k, times);
            }
        }
        return res;
    }


}
