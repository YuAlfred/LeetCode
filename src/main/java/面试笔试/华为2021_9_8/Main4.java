package 面试笔试.华为2021_9_8;

import java.util.PriorityQueue;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/8 6:36 下午
 */
public class Main4 {

    public static void main(String[] args) {

        int[] nums = new int[1000];
        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            // 堆超过10就抛出最小的
            if (queue.size() > 10) {
                queue.poll();
            }
        }
        // 转换为int数组
        int[] ans = queue.stream().mapToInt(Integer::intValue).toArray();


    }


}
