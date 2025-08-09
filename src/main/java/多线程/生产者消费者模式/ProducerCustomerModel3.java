package 多线程.生产者消费者模式;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 生产者消费者模式
 * @date: 2021/3/5 8:19 下午
 * <p>
 * 第三版，Semaphore
 */
public class ProducerCustomerModel3 {

    final static int MAX = 100;
    LinkedList<Integer> queue = new LinkedList<>();

    Semaphore full = new Semaphore(MAX);
    Semaphore empty = new Semaphore(0);


    int readData() throws InterruptedException {
        Thread.sleep((long) Math.random() * 1000);
        return (int) Math.floor(Math.random());
    }

    //Producer
    public void readDB() throws InterruptedException {
        full.acquire();
        int data = readData();
        synchronized (queue) {
            queue.add(data);
        }
        empty.release();
    }

    //Customer
    public void calculator() throws InterruptedException {
        empty.acquire();
        synchronized (queue){
            int data = queue.remove();
        }
        System.out.println("queue size: " + queue.size());
        full.release();
    }


    public static void main(String[] args) {
        ProducerCustomerModel3 p = new ProducerCustomerModel3();

        //一百个生产者生产
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        p.readDB();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        //一个消费者消费
        new Thread(() -> {
            while (true) {
                try {
                    p.calculator();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
