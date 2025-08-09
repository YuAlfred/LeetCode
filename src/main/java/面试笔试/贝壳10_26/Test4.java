package 面试笔试.贝壳10_26;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2020/10/26 4:17 下午
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int array = (m * n) / 3;
        int diff = m * n;
        //横切
        int k = (array / m);
        for (int i = k - 1 > 1 ? k - 1 : 1; i <= (k + 1 >= n ? n - 1 : k + 1); i++) {
            int arr1 = m * i;
            int arr2 = (m / 2) * (n - i);
            int arr3 = (m - (m / 2)) * (n - i);
            int tempDiff = Math.max(Math.abs(arr1 - arr2), Math.abs(arr3 - arr1));
            tempDiff = Math.max(tempDiff, Math.abs(arr3 - arr2));
            diff = Math.min(diff, tempDiff);
        }
        //纵切
        k = (array / n);
        for (int i = k - 1 > 1 ? k - 1 : 1; i <= (k + 1 >= m ? m - 1 : k + 1); i++) {
            int arr1 = n * i;
            int arr2 = (n / 2) * (m - i);
            int arr3 = (n - (n / 2)) * (m - i);
            int tempDiff = Math.max(Math.abs(arr1 - arr2), Math.abs(arr3 - arr1));
            tempDiff = Math.max(tempDiff, Math.abs(arr3 - arr2));
            diff = Math.min(diff, tempDiff);
        }
        System.out.println(diff);
    }
}
