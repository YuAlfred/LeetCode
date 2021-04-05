package 面试笔试.阿里2021_4_2;

import java.util.Scanner;

/**
 * @author : ty
 * @version :
 * @date : Created in 2021/4/2 18:59
 * @description :
 * @modified By  :
 */

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            if (n % 25 > 0) {
                n = (n - (n % 25)) + 25;
            }
            System.out.printf("%.8f%n",getProbability(n, n));
        }
        in.close();
    }

    public static Map<Integer, Map<Integer, Double>> dp = new HashMap<>();

    public static double getProbability(int a, int b) {
        if (dp.containsKey(a) && dp.get(a).containsKey(b)) {
            return dp.get(a).get(b);
        }
        double probability = 0;

        int tempA;
        int tempB;
        // 操作一
        tempA = a - 100;
        tempB = b;
        probability += oneHand(tempA, tempB);
        // 操作二
        tempA = a - 75;
        tempB = b - 25;
        probability += oneHand(tempA, tempB);
        // 操作三
        tempA = a - 50;
        tempB = b - 50;
        probability += oneHand(tempA, tempB);
        // 操作四
        tempA = a - 25;
        tempB = b - 75;
        probability += oneHand(tempA, tempB);

//        if (!dp.containsKey(a)) {
//            dp.put(a, new HashMap<>());
//        }
//        Map<Integer, Double> bMap = dp.get(a);
//        bMap.put(b, probability);

        return probability;
    }

    public static double oneHand(int tempA, int tempB) {
        double probability = 0;
        tempA = Math.max(tempA, 0);
        tempB = Math.max(tempB, 0);
        if (tempA > 0 && tempB > 0) {
            probability += (getProbability(tempA, tempB)) / 4.0;
        } else if (tempA == 0 && tempB != 0) {
            probability += (1 / 4.0);
        } else if (tempA == 0) {
            probability += (1 / 8.0);
        }
        return probability;
    }
}
