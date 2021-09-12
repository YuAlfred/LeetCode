package 面试笔试.字节跳动移动端_2021_9_12;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt() + start;
            queue.add(end);
            while (queue.peek() < start) {
                queue.poll();
            }
            ans = Math.max(ans, queue.size());
        }
        in.close();

        System.out.println(ans);
    }

}
