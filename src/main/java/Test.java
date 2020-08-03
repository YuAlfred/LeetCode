import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/7/22 21:23
 * @description :
 * @modified By  :
 */
public class Test {

    public static class Student {
        int price;
        int up;

        public Student(int price, int up) {
            this.price = price % 1000000003;
            this.up = up;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Student>> studentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int price = in.nextInt();
            int up = in.nextInt();
            if (studentMap.get(up) == null) {
                List<Student> studentList = new LinkedList<>();
                studentList.add(new Student(price, up));
                studentMap.put(up, studentList);
            } else {
                studentMap.get(up).add(new Student(price, up));
            }
        }
        in.close();

    }

}
