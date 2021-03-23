package 多线程.轮流打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/22 6:37 下午
 */
public class MainWithCondition {

    static int number = 1;


    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        ReentrantLock lock = new ReentrantLock();
        Condition canT1do = lock.newCondition(), canT2do = lock.newCondition(), canT3do = lock.newCondition();
        Thread t1 = new Thread(new task(lock, 1, canT1do, canT2do));
        Thread t2 = new Thread(new task(lock, 2, canT1do, canT3do));
        Thread t3 = new Thread(new task(lock, 3, canT1do, canT1do));
        t1.start();
        t2.start();
        t3.start();

    }


    public static void method1() {
    }

    static class task implements Runnable {

        private ReentrantLock lock;
        private int id;
        private Condition canIDo;
        private Condition canNextDo;
        private int end = 36;

        public task(ReentrantLock lock, int id, Condition canIDo, Condition canNextDo) {
            this.lock = lock;
            this.id = id;
            this.canIDo = canIDo;
            this.canNextDo = canNextDo;
        }

        @Override
        public void run() {
            while (number <= end) {
                lock.lock();
                try {
                    int no = number % 9;
                    if ((no == 1 || no == 2 || no == 3) && id == 1 || ((no == 4 || no == 5 || no == 6) && id == 2) || ((no == 7 || no == 8 || no == 0) && id == 3)) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("线程" + id + ": " + number);
                            number++;
                        }
                        canIDo.signalAll();
                    } else {
                        canIDo.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
