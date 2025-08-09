package 面试笔试.字节2021_10_17;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/10/17 7:07 下午
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        while (true) {
            String line = in.next();
            if (line.equals("0")) {
                break;
            }
            list.add(line);
        }
        in.close();


    }

}
