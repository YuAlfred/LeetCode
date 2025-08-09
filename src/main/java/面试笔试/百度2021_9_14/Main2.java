package 面试笔试.百度2021_9_14;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/14 7:28 下午
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        int q = in.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 1; i <= q; i++) {
            int step = 0;
            long moveNum = in.nextInt();
            // 首先所有移动的人至少移动一步
            step += moveNum;
            // 这样i+moveNum前面至少有一个空格
            queue.add(i + moveNum);
            // 然后算空格
            while (!queue.isEmpty() && queue.peek() < (i + moveNum)) {
                long location = queue.poll();
                queue.add(i + moveNum);
                step += (i + moveNum - location);
            }
            System.out.print(step + " ");
        }
        in.close();
    }
}
