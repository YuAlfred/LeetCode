package 多线程.ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/7 3:25 下午
 * <p>
 * <p>
 * 用十个线程分别打印出时间信息，
 */
public class ThreadLocalNormalUsage01 {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(()->{
                String date = new ThreadLocalNormalUsage01().date(finalI);
                System.out.println(date);
            }).start();
            Thread.sleep(100);
        }
    }


    public String date(int seconds) {
        //参数的单位是毫秒，从1970 0：0：0 到西现在的毫秒数
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }


}
