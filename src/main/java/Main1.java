import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : ty
 * @version :
 * @date : Created in 2021/2/19 21:03
 * @description :
 * @modified By  :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<String> inTown = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String num = in.next();
            if (inTown.contains(num)) {
                inTown.remove(num);
            } else {
                inTown.add(num);
            }
        }
        in.close();
        System.out.println(inTown.size());
    }

}
