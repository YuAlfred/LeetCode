package 面试笔试.字节跳动移动端_2021_9_12;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = in.nextInt();
            tasks[i][1] = in.nextInt() + tasks[i][0];
        }
        in.close();

        Arrays.sort(tasks, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = 0;
        int cur = 0;
        for (int[] task : tasks) {
            int curTime = task[0];
            queue.add(task[1]);
            cur++;
            while (!queue.isEmpty()&&queue.peek()<curTime){
                queue.poll();
                cur--;
            }
            max = Math.max(max,cur);
        }
        System.out.println(max);

    }

}
