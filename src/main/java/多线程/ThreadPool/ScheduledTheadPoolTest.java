package 多线程.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 8:29 下午
 */
public class ScheduledTheadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //五秒后运行
        // scheduledExecutorService.schedule(() -> {
        //     System.out.println(Thread.currentThread().getName());
        // }, 5, TimeUnit.SECONDS);

        //周期性运行，一开始延时一秒，后面每隔三秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName());
        }, 1,3, TimeUnit.SECONDS);
    }

}
