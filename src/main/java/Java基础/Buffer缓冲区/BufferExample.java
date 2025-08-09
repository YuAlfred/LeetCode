package Java基础.Buffer缓冲区;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/8 11:15 上午
 */
public class BufferExample {


    @Test
    public void gen() throws IOException {

        Random r = new Random();
        String fileName = "word";

        // int bufferSize = 4 * 1024;
        BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(fileName));

        long start = System.currentTimeMillis();

        //写十亿个单词，每个单词5个字母
        for (int i = 0; i < 100000000; i++) {
            for (int j = 0; j < 5; j++) {
                fout.write('a' + r.nextInt(5));
            }
            fout.write(' ');
        }

        fout.close();
        System.out.println(System.currentTimeMillis() - start);
    }

    public void readTest() throws IOException {
        String fileName = "word";
        FileInputStream fin = new FileInputStream(fileName);

        long start = System.currentTimeMillis();

        int b;
        //读完整个文件
        while ((b = fin.read()) != -1) {

        }

        //需要花很长时间！！！
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void readTestWithBuffer() throws IOException {
        String fileName = "word";

        // int bufferSize = 4 * 1024;
        BufferedInputStream fin = new BufferedInputStream(new FileInputStream(fileName));

        long start = System.currentTimeMillis();

        int b;
        //读完整个文件
        //一个一个字节读非常慢，要八秒多，一次一个数组就快多了,只要0.1秒
        byte[] bytes = new byte[1024 * 8];
        while ((b = fin.read(bytes)) != -1) {

        }

        //大概需要八秒多
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void readWithNIO() throws IOException {
        String fileName = "word";

        FileChannel channel = new FileInputStream(fileName).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);

        long start = System.currentTimeMillis();

        while (channel.read(buffer) != -1) {

            //读之前要先flip()
            buffer.flip();
            // System.out.println(new String(buffer.array()));
            //记得如果还要继续写的花要clear
            buffer.clear();
            // break;
        }

        // 只需要0.1秒！！！！
        System.out.println(System.currentTimeMillis() - start);

    }
}
