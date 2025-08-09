package 面试笔试.美团2021_3_13;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/13 2:27 下午
 */

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int K = in.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (deque.size() < K) {
                deque.addLast(a);
                map.put(a, map.getOrDefault(a, 0) + 1);
            } else {
                //找众数
                int times = 1;
                int num = deque.peek();
                for (int key : map.keySet()) {
                    if (map.get(key) > times) {
                        times = map.get(key);
                        num = key;
                    } else if (map.get(key) == times && key < num) {
                        num = key;
                    }
                }
                //输出
                System.out.println(num);

                deque.addLast(a);
                map.put(a, map.getOrDefault(a, 0) + 1);
                int removed = deque.pollFirst();
                int res = map.get(removed);
                res--;
                if (res == 0) {
                    map.remove(removed);
                } else {
                    map.put(removed, res);
                }
            }
        }
        //找众数
        int times = -1;
        int num = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > times) {
                times = map.get(key);
                num = key;
            } else if (map.get(key) == times && key < num) {
                num = key;
            }
        }
        //输出
        System.out.println(num);
        in.close();
    }
}
