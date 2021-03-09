package Java基础.Buffer缓冲区;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/8 2:54 下午
 */
public class 中文处理乱码 {

    public static void main(String[] args) {

        String str = "处理中文乱码示例";

        Charset charset = StandardCharsets.UTF_8;
        //模拟从文件中读到的一个ByteBuffer
        ByteBuffer bufferBytes = charset.encode(str);
        byte[] bytes = bufferBytes.array();

        int start = 0;
        int size = 10;

        //从buffer中开始处理
        ByteBuffer bbuf = ByteBuffer.allocate(size * 2);
        CharBuffer cbuf = CharBuffer.allocate(size * 2);

        while (start < bytes.length) {
            int end = start + size;
            //拷贝一部分到byte数组
            byte[] buffer = Arrays.copyOfRange(bytes, start, end);


            bbuf.put(buffer);
            bbuf.flip();


            charset.newDecoder().decode(bbuf, cbuf, true);
            cbuf.flip();

            System.out.println(new String(cbuf.array()));
            System.out.println("position: " + bbuf.position() + " ,limit: " + bbuf.limit());

            byte[] left = Arrays.copyOfRange(bbuf.array(), bbuf.position(), bbuf.limit() + 1);

            bbuf.clear();
            bbuf.put(left);

            cbuf.clear();

            System.out.println("position: " + bbuf.position() + " ,limit: " + bbuf.limit());
            start = end + 1;
        }


    }
}
