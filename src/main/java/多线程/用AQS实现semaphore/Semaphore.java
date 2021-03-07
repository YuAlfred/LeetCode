package 多线程.用AQS实现semaphore;

import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 自己实现一个信号量
 * @date: 2021/3/6 10:36 上午
 */
public class Semaphore extends AbstractQueuedSynchronizer {


    public Semaphore(int arg) {
        setState(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        int stat = getState();
        if (stat == 0) {
            return -1;
        }
        int left = stat - 1;
        if (compareAndSetState(stat, left)) {
            return left;
        }
        return -1;
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        int stat = getState();
        return compareAndSetState(stat, stat + 1);
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                semaphore.acquireShared(0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("go");
                semaphore.releaseShared(0);
            }).start();
        }


    }


}
