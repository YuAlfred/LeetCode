package Java基础.Buffer缓冲区;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/8 2:54 下午
 */
public class 中文处理乱码 {

    static String str =
        "帝高阳之苗裔兮，朕皇考曰伯庸。\n" +
            "摄提贞于孟陬兮，惟庚寅吾以降。\n" +
            "皇览揆余初度兮，肇锡余以嘉名。\n" +
            "名余曰正则兮，字余曰灵均。\n" +
            "纷吾既有此内美兮，又重之以修能。\n" +
            "扈江离与辟芷兮，纫秋兰以为佩。\n" +
            "汩余若将不及兮，恐年岁之不吾与。\n" +
            "朝搴阰之木兰兮，夕揽洲之宿莽。";


    public static void main(String[] args) throws IOException {

        int buffSize = 10;
        ByteBuffer bbuf = ByteBuffer.allocate(buffSize);
        CharBuffer cbuf = CharBuffer.allocate(buffSize);

        //UTF-8的解码器
        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();


        //打开文件Channel
        FileChannel fileChannel = new FileInputStream("/Users/alfredt/IdeaProjects/LeetCode/utf8word").getChannel();

        //开始读文件写入bbuf
        while (fileChannel.read(bbuf) != -1) {

            //bbuf从写状态到读状态
            bbuf.flip();
            //从bbuf解码到cbuf
            decoder.decode(bbuf, cbuf, true);

            //cbuf从写到读 输出cbuf
            cbuf.flip();
            System.out.print(cbuf.toString());

            int restLength = bbuf.limit() - bbuf.position();
            byte[] res = new byte[restLength];
            //把剩余到读到字节数组中记录下来
            bbuf.get(res, 0, restLength);

            //从读到写
            bbuf.clear();
            //把刚刚剩余的字节写会bbuf
            bbuf.put(res, 0, restLength);

            cbuf.clear();

        }
    }
}
