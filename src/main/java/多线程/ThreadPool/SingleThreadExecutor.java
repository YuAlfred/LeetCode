package 多线程.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 7:47 下午
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

}
