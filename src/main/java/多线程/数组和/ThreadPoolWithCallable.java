package 多线程.数组和;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 7:00 下午
 */
public class ThreadPoolWithCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] nums = new int[10000000];
        Arrays.fill(nums, Integer.MAX_VALUE / 2);

        long time = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);


        int gap = 10000;
        int start = 0;
        int end = start + gap;
        long res = 0;
        List<Future<Long>> futures = new LinkedList<>();

        while (end < nums.length) {
            futures.add(executorService.submit(new CallableTask(nums, start, end)));
            start = end + 1;
            end += gap;
        }
        futures.add(executorService.submit(new CallableTask(nums, start, nums.length - 1)));


        for (Future future : futures) {
            res += (Long) future.get();
        }

        System.out.println("最终结果：" + res + ",计算用时：" + (System.currentTimeMillis() - time) + "毫秒");
        executorService.shutdown();
    }


}

class CallableTask implements Callable<Long> {

    int[] nums;
    int start;
    int end;
    long sum;

    public CallableTask(int[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
