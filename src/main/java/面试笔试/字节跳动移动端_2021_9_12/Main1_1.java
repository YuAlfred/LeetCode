package 面试笔试.字节跳动移动端_2021_9_12;

import java.util.*;

public class Main1_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt() + start;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        in.close();

        int ans = 0;
        int cur = 0;
        for (Integer value : map.values()) {
            cur += value;
            ans = Math.max(cur, ans);
        }
        System.out.println(ans);
    }

}
