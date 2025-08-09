package 多线程.BlockingQueue;

import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/15 10:57 上午
 */
public class BlockingQueueTest {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue;

        //有容量限制，容量初始化时就要确定
        queue = new ArrayBlockingQueue<>(10);
        // 可有界可无界，构造器传入参数就代表有界，无参则无界限
        // queue = new LinkedBlockingQueue<>();
        // 类比LinkedBlockingQueue，但是是双向的
        // queue = new LinkedBlockingDeque<>();
        // 会作排序，每次取出是队列中最小的，
        // queue = new PriorityBlockingQueue<>();
        // 调用offer()和poll()时它就是LinkedBlockingQueue，
        // queue = new LinkedTransferQueue<>();
        // 反向的，用offer时需要先被poll
        // queue = new SynchronousQueue<>();
        // 要自己定义类型，实现Delay接口
        // queue = new DelayQueue<>();


        //生产者
        for (int i = 0; i < 100; i++) {
            new Thread(() -> queue.offer((int) (Math.random() * 1000))).start();
        }
        
        // 消费者
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    Integer x= queue.poll();
                    System.out.println("Receive: "+x);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        
    }


}
