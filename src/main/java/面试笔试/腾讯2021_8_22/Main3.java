package 面试笔试.腾讯2021_8_22;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/2/2 8:03 下午
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // T组
        int T = in.nextInt();
        // 结果列表
        List<Integer> ansList = new ArrayList<>(T);
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int w = in.nextInt();
            // 奇偶数体重
            List<Integer> oddWeight = new ArrayList<>(n);
            List<Integer> evenWeight = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int weight = in.nextInt();
                if ((weight & 1) == 1) {
                    oddWeight.add(weight);
                } else {
                    evenWeight.add(weight);
                }
            }

            oddWeight.sort((o1, o2) -> o2 - o1);
            evenWeight.sort((o1, o2) -> o2 - o1);

            int ans = 0;
            // 奇偶分别遍历
            ans += find(oddWeight, w);
            ans += find(evenWeight, w);

            ansList.add(ans);
        }

        for (Integer i : ansList) {
            System.out.println(i);
        }

        in.close();
    }

    public static int find(List<Integer> weightList, int w) {
        int ans = 0;
        int l = 0, r = weightList.size() - 1;
        while (l <= r) {
            if (weightList.get(l) + weightList.get(r) <= w) {
                l++;
                r--;
            } else {
                l++;
            }
            ans++;
        }
        return ans;
    }

}