package 多线程.数组和;


import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 7:00 下午
 */
public class ForkJoinThreadPool {

    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[10000000];
        Arrays.fill(nums, Integer.MAX_VALUE / 2);

        long time = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool(3);

        Long res =  forkJoinPool.invoke(new ForkJoinTask(nums, 0, nums.length - 1));
        // forkJoinPool.shutdown();


        System.out.println("最终结果：" + res + ",计算用时：" + (System.currentTimeMillis() - time) + "毫秒");
    }

}

class ForkJoinTask extends RecursiveTask<Long> {

    int[] nums;
    int start;
    int end;
    long res;

    public ForkJoinTask(int[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) < 10000) {
            for (int i = start; i <= end; i++) {
                res += nums[i];
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoinTask leftTask = new ForkJoinTask(nums, start, middle);
            ForkJoinTask rightTask = new ForkJoinTask(nums, middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            res = leftTask.join() + rightTask.join();
        }
        return res;
    }
}
