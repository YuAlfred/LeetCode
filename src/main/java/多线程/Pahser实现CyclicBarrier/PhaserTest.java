package 多线程.Pahser实现CyclicBarrier;

import sun.security.krb5.internal.PAData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 2:14 下午
 */
public class PhaserTest {

    Phaser phaser = new Phaser();
    ExecutorService executorService = Executors.newCachedThreadPool();

    class Worker implements Runnable {
        @Override
        public void run() {
            phaser.register();
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("I'm working @" + phaser.getPhase());
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        phaser.register();
        executorService.execute(new Worker());
        executorService.execute(new Worker());
        executorService.execute(new Worker());
        executorService.execute(new Worker());
        while (true) {
            phaser.arriveAndAwaitAdvance();
            // do some sync
            System.out.println("Sync.... " + phaser.getPhase());
        }
    }

    public static void main(String[] args) {
        PhaserTest test = new PhaserTest();
        test.run();
    }

}
