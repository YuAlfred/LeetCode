package 多线程.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 1:34 下午
 */
public class CyclicBarrierTest {

    CyclicBarrier barrier;
    int page = 0;

    public CyclicBarrierTest() {
        barrier = new CyclicBarrier(2, () -> {
            System.out.println("同步中。。。");
            page++;
        });

    }

    //准备产品
    void prepareProduct() {
        while (page < 1000) {
            try {
                System.out.println("准备产品Page:" + page);
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    //准备发货单
    void prepareDeliveryOrder() {
        while (page < 1000) {
            try {
                System.out.println("准备发货单,Page:" + page);
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    void run() {
        //一个线程去准备产品，一个线程去准备发货单
        new Thread(() -> {
            prepareProduct();
        }).start();
        new Thread(() -> {
            prepareDeliveryOrder();
        }).start();
    }

    public static void main(String[] args) {
        CyclicBarrierTest c = new CyclicBarrierTest();
        c.run();
    }

}
