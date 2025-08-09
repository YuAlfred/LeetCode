package 多线程.ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/7 3:25 下午
 * <p>
 * <p>
 * 用线程池管理线程分别打印出时间信息，
 * 1000个打印日期的任务
 */
public class ThreadLocalNormalUsage02 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.execute(() -> {
                String date = new ThreadLocalNormalUsage02().date(finalI);
                System.out.println(date);
            });
        }
        executorService.shutdown();
    }


    public String date(int seconds) {
        //参数的单位是毫秒，从1970 0：0：0 到西现在的毫秒数
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }


}
