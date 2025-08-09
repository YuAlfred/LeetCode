package 面试笔试.华为模拟笔试;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/7 3:15 下午
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        String[] words = s.split(" ");
        int total = 0;
        for (String word : words) {
            total += word.length();
        }
        System.out.printf("%.2f", total / (double) words.length);
    }


}
