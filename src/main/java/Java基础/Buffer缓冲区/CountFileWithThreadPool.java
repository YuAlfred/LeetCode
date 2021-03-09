package Java基础.Buffer缓冲区;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/9 3:59 下午
 */
public class CountFileWithThreadPool {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        InputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/alfredt/IdeaProjects/LeetCode/word"));

        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Long>> futures = new LinkedList<>();

        int buffSize = 4 * 1024;
        byte[] buffer = new byte[buffSize];
        String key = "aacca";

        while ((inputStream.read(buffer)) != -1) {
            Future<Long> future = executorService.submit(new FileCount(key, buffer));
            buffer = new byte[buffSize];
            futures.add(future);
        }

        long res = 0;
        for (Future<Long> future : futures) {
            res += future.get();
        }
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start);
        inputStream.close();
    }


}

class FileCount implements Callable<Long> {

    String key;
    byte[] buffer;

    public FileCount(String key, byte[] buffer) {
        this.key = key;
        this.buffer = buffer;
    }

    public Long call() {
        return (long) (new String(buffer).split(key).length - 1);
    }


}
