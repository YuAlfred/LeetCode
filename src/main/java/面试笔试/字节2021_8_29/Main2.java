package 面试笔试.字节2021_8_29;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/8/29 10:27 上午
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        TreeSet<People> treeSet = new TreeSet<>();
        int t = 0, z = 0, w = 0;
        for (int i = 0; i < m; i++) {
            t += in.nextInt();
            z += in.nextInt();
            w += in.nextInt();
            treeSet.add(new People(i + 1, t, z, w));
        }
        for (int i = 0; i < n; i++) {
            People p = new People(0, in.nextInt(), in.nextInt(), in.nextInt());
            People res = treeSet.ceiling(p);
            System.out.println(res == null ? -1 : res.day);
        }

    }

    static class People implements Comparable {

        int day;
        int t;
        int z;
        int w;

        public People(int day, int t, int z, int w) {
            this.day = day;
            this.t = t;
            this.z = z;
            this.w = w;
        }

        @Override
        public int compareTo(Object o) {
            People p = (People) o;
            if (this.t == p.t && this.z == p.z && this.w == p.w) {
                return 0;
            } else if (this.t <= p.t && this.z <= p.z && this.w <= p.w) {
                return -1;
            } else {
                return 1;
            }
        }
    }


}
