package 华为9_9;


/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/9 7:08 下午
 * @description : 完美排列
 * @modified By  :
 */

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        StringBuilder perfectLook = new StringBuilder();
        StringBuilder perfectValue = new StringBuilder();
        for (int i = 0; i < k; i++) {
            perfectLook.append(in.nextInt());
        }
        for (int i = 0; i < k; i++) {
            perfectValue.append(in.nextInt());
        }
        int n = in.nextInt();
        StringBuilder curLook = new StringBuilder();
        StringBuilder curValue = new StringBuilder();
        for (int i = 0; i < n; i++) {
            curLook.append(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            curValue.append(in.nextInt());
        }
        if (curLook.indexOf(perfectLook.toString())== curValue.indexOf(perfectValue.toString())){
            System.out.println(curLook.indexOf(perfectLook.toString())+1);
        }else {
            System.out.println(0);
        }
    }
}
