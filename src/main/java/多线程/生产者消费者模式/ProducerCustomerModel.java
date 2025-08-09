package 多线程.生产者消费者模式;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 生产者消费者模式
 * @date: 2021/3/5 8:19 下午
 * <p>
 * 第一版，sychronized实现，生产者消费者自旋解决问题
 */
public class ProducerCustomerModel {

    final static int MAX = 10;
    LinkedList<Integer> queue = new LinkedList<>();

    int readData() throws InterruptedException {
        Thread.sleep((long) Math.random() * 1000);
        return (int) Math.floor(Math.random());
    }

    //Producer
    public void readDB() throws InterruptedException {
        synchronized (queue) {
            if (queue.size() == MAX) {
                return;
            }
            int data = readData();
            queue.add(data);
        }
    }

    //Customer
    public void calculator() throws InterruptedException {
        synchronized (queue) {
            if (queue.size() == 0) {
                return;
            }
            int data = queue.remove();
            System.out.println("queue size: " + queue.size());

            data *= 100;
        }
    }


    public static void main(String[] args) {
        ProducerCustomerModel p = new ProducerCustomerModel();

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
