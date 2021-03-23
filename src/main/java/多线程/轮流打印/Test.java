package 多线程.轮流打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/22 8:35 下午
 */
public class Test {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition canT1Do = lock.newCondition(), canT2Do = lock.newCondition(), canT3Do = lock.newCondition();
        new Thread(new Task(lock, condition, 1)).start();
        new Thread(new Task(lock, condition, 2)).start();
        new Thread(new Task(lock, condition, 3)).start();
    }

    static int curNumber = 1;

    static class Task implements Runnable {

        private ReentrantLock lock;
        private int endNumber = 36;
        private int threadId;
        private Condition condition;

        public Task(ReentrantLock lock, Condition condition, int threadId) {
            this.lock = lock;
            this.threadId = threadId;
            this.condition = condition;
//            this.canIdo = canIdo;
//            this.canNextDo = canNextDo;
        }

        @Override
        public void run() {
            while (curNumber <= endNumber) {
                lock.lock();
                try {
                    if (checkNumberAndThreadId(curNumber % 9, threadId)) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("线程" + threadId + ": " + curNumber);
                            curNumber++;
                        }
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public boolean checkNumberAndThreadId(int number, int id) {
            return ((curNumber == 1 || curNumber == 2 || curNumber == 3) && threadId == 1) || ((curNumber == 4 || curNumber == 5 || curNumber == 6) && threadId == 2) || ((curNumber == 7 || curNumber == 8 || curNumber == 0) && threadId == 3);
        }
    }

}