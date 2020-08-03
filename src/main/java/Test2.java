import java.util.*;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/7/24 19:33
 * @description :
 * @modified By  :
 */
public class Test2 {

    public static class Course {
        int s;
        int e;

        public Course(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Course> courses = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            courses.add(new Course(in.nextInt(), in.nextInt()));
        }
        in.close();

        Collections.sort(courses, Comparator.comparingInt(o -> o.s));
        int K = 1;
        for (int i = 0; i < courses.size(); i++) {
            int tempK = 1;
            int end = courses.get(i).e;
            for (int j = i + 1; j < courses.size(); j++) {
                if (courses.get(j).s < end) {
                    tempK++;
                } else {
                    break;
                }
            }
            if (tempK > K) {
                K = tempK;
            }
        }
        System.out.println(K);
    }
}

