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
public class ThreadPoolWithRunnable {

    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[10000000];
        Arrays.fill(nums, Integer.MAX_VALUE / 2);

        long time = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Phaser phaser = new Phaser();
        phaser.register();

        int gap = 10000;
        int start = 0;
        int end = start + gap;
        AtomicLong ans = new AtomicLong(0);

        while (end < nums.length) {
            phaser.register();
            executorService.execute(new RunnableTask(nums, start, end, ans, phaser));
            start = end + 1;
            end += gap;
        }
        phaser.register();
        executorService.execute(new RunnableTask(nums, start, nums.length - 1, ans, phaser));

        phaser.arriveAndAwaitAdvance();

        System.out.println("最终结果：" + ans.get() + ",计算用时：" + (System.currentTimeMillis() - time) + "毫秒");
        executorService.shutdown();
    }

}

class RunnableTask implements Runnable {

    int[] nums;
    int start;
    int end;
    long sum;
    AtomicLong res;
    Phaser phaser;

    public RunnableTask(int[] nums, int start, int end, AtomicLong res, Phaser phaser) {
        this.nums = nums;
        this.start = start;
        this.end = end;
        this.res = res;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        res.getAndAdd(sum);
        // System.out.println("我是：" + Thread.currentThread().getName() + ",我计算了:" + sum);
        phaser.arrive();
    }
}
