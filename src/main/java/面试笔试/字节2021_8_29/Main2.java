package 面试笔试.字节2021_8_29;

import java.util.*;

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
        List<People> list = new ArrayList<>(m);
        int t = 0, z = 0, w = 0;
        for (int i = 0; i < m; i++) {
            t += in.nextInt();
            z += in.nextInt();
            w += in.nextInt();
            list.add(new People(i + 1, t, z, w));
        }
        for (int i = 0; i < n; i++) {
            People p = new People(0, in.nextInt(), in.nextInt(), in.nextInt());
            System.out.println(binSearch(list, p) + " ");
        }

    }

    public static int binSearch(List<People> list, People people) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            People middleP = list.get(m);
            if (middleP.compareTo(people) >= 0) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (l == list.size()) {
            return -1;
        } else {
            return list.get(l).day;
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
            } else if (this.t >= p.t && this.z >= p.z && this.w >= p.w) {
                return 1;
            } else {
                return -1;
            }
        }
    }


}
