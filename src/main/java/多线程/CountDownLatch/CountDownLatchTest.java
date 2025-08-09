package 多线程.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 1:51 下午
 * 抽象了一个叫做RPC的任务，相当于封装一个远程RPC请求。如果4个请求需要同步，那么我们可以用CountDownLatch。
 * 每个线程获取数据后，执行一次countDown 方法，这样主线程的latch.await 方法收集够4个线程的countDown之后，就会继续执行。
 */
public class CountDownLatchTest {

    class RPC implements Runnable {
        String url;
        CountDownLatch latch;

        public RPC(String url, CountDownLatch latch) {
            this.url = url;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("request");
            latch.countDown();
        }
    }

    public void run() throws InterruptedException {
        List<RPC> requests = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(4);
        requests.add(new RPC("rpa://A", latch));
        requests.add(new RPC("rpa://B", latch));
        requests.add(new RPC("rpa://C", latch));
        requests.add(new RPC("rpa://D", latch));
        requests.forEach((o)-> new Thread(o).start());
        latch.await();
        // merge 4 requests result
        System.out.println("merge");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest test = new CountDownLatchTest();
        test.run();
    }
}
