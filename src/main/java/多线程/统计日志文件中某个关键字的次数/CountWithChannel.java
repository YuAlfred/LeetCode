package 多线程.统计日志文件中某个关键字的次数;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/16 1:00 下午
 */
public class CountWithChannel {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String filePath = "/Users/alfredt/IdeaProjects/LeetCode/word";
        long length = new File(filePath).length();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futures = new LinkedList<>();

        long start = 0;
        long gap = 4 * 1024;
        while (start < length) {
            long next = start + gap;
            next = Math.min(next, length);
            futures.add(executorService.submit(new Task(filePath, "aabcc", start, next)));
            start = next;
        }
        long res = 0;
        for (Future<Long> future : futures) {
            res += future.get();
        }
        System.out.println(res);

    }

}

class Task implements Callable<Long> {

    String filePath;
    String key;
    long start;
    long end;

    public Task(String filePath, String key, long start, long end) {
        this.filePath = filePath;
        this.key = key;
        this.start = start;
        this.end = end;
    }

    public Long call() throws IOException {

        RandomAccessFile raf = new RandomAccessFile(filePath, "r");
        FileChannel channel = raf.getChannel();


        ByteBuffer bbuf = channel.map(FileChannel.MapMode.READ_ONLY, start, end - start);

        CharsetDecoder decoder = StandardCharsets.US_ASCII.newDecoder();
        CharBuffer cbuf = decoder.decode(bbuf);

        raf.close();
        return (long) (cbuf.toString().split(key).length - 1);
    }

}
