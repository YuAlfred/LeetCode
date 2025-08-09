package 多线程.生产者消费者模式;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 8:09 下午
 */
public class TestModel {

    int MAX = 10;

    LinkedList<Integer> queue = new LinkedList<>();
    ReentrantLock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();

    public void product() throws InterruptedException {
        lock.lock();
        if (queue.size() == MAX) {
            full.await();
            return;
        }
        queue.add(1);
        System.out.println(queue.size());
        empty.signalAll();
        lock.unlock();
    }

    public void consumer() throws InterruptedException {
        lock.lock();
        if (queue.size() == 0) {
            empty.await();
            return;
        }
        queue.pop();
        full.signalAll();
        System.out.println(queue.size());
        lock.unlock();
    }

    public static void main(String[] args) {
        TestModel test = new TestModel();
        //100个生产者
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        test.product();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //一个消费者
        new Thread(() -> {
            while (true) {
                try {
                    test.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
