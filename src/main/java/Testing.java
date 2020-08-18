import java.util.*;

public class Testing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp += num[j];
            }
            num[i] = temp + 1;
        }
        System.out.println(num[n - 1]);
    }
}