package 多线程.ThreadPool;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 每个任务分配一个线程
 * @date: 2021/3/6 3:07 下午
 */
public class EveryTaskOneThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        t1.start();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("执行了任务");
        }
    }


}
