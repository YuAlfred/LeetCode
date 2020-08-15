import java.util.*;

public class Testing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        String start = null;
        for (int i = 0; i < n; i++) {
            String tStart = sc.next();
            String tEnd = sc.next();
            if (start == null) {
                start = tStart;
                continue;
            }
            if (tEnd.equals(start)) {
                num++;
                start = null;
                continue;
            }
        }
        sc.close();
        System.out.println(num);
    }
}