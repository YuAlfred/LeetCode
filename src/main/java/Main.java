import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/7/22 21:23
 * @description :
 * @modified By  :
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int p = in.nextInt();
        in.close();

        Arrays.sort(a);
        Arrays.sort(b);


    }

    public int max = 0;

    public void recur(int[] a, int[] b, int i, int j) {


    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
