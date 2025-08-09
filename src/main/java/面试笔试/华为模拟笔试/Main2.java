package 面试笔试.华为模拟笔试;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/7 3:15 下午
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        char[] cs = s.toLowerCase().toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cs[i] = Character.toUpperCase(c);
            }
        }
        System.out.println(new String(cs));
    }


}
