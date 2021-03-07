package 多线程.生产者消费者模式;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 生产者消费者模式
 * @date: 2021/3/5 8:19 下午
 * <p>
 * 第二版，Condition+ReentrantLock
 */
public class ProducerCustomerModel2 {

    final static int MAX = 10;
    LinkedList<Integer> queue = new LinkedList<>();

    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();

    int readData() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000));
        return (int) Math.floor(Math.random());
    }

    //Producer
    public void readDB() throws InterruptedException {
        lock.lock();
        if (queue.size() == MAX) {
            full.await();
            return;
        }
        int data = readData();
        if (queue.size() == 1) {
            empty.signalAll();
        }
        queue.add(data);
        lock.unlock();
    }

    //Customer
    public void calculator() throws InterruptedException {
        lock.lock();
        if (queue.size() == 0) {
            empty.await();
            return;
        }
        int data = queue.remove();
        System.out.println("queue size: " + queue.size());
        if (queue.size() == MAX - 1) {
            full.signalAll();
        }
        data *= 100;
        lock.unlock();
    }


    public static void main(String[] args) {
        ProducerCustomerModel2 p = new ProducerCustomerModel2();
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
