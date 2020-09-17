package 面试笔试.京东前端8_27;


/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/8/27 8:08 下午
 * @description :
 * @modified By  :
 */

import java.util.*;

public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        in.close();
        StringBuffer bf = new StringBuffer(n);
        bf.reverse();
        String res = Integer.toString(Integer.parseInt(bf.toString()), 5);
        System.out.println(res);
    }
}
