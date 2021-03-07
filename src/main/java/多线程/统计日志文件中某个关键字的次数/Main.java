package 多线程.统计日志文件中某个关键字的次数;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/6 9:33 下午
 */
public class Main {


    public static void main(String[] args) throws IOException {
        AtomicLong times = new AtomicLong(0);
        Phaser phaser = new Phaser();
        phaser.register();
        int BUFF_SIZE = 10000;
        byte[] buff = new byte[BUFF_SIZE];
        int start = 0;
        int end = BUFF_SIZE;
        String key = "";

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        RandomAccessFile raf = new RandomAccessFile("", "r");

        int read_count = raf.read(buff);
        while (read_count >= 0) {
            for (int i = BUFF_SIZE - 1; i >= 0; i--) {
                if (buff[i] == '\n') {
                    start += (i + 1);
                    end = start + BUFF_SIZE;
                    break;
                }
            }
            executorService.execute(new Count(times, key, new String(buff,start,end), phaser));
        }


    }


}

class Count implements Runnable {

    AtomicLong times;
    String key;
    String str;
    Phaser phaser;

    public Count(AtomicLong times, String key, String str, Phaser phaser) {
        this.times = times;
        this.key = key;
        this.str = str;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        times.getAndAdd(str.split(key).length - 1);
        phaser.arrive();
    }
}
