import java.util.*;

public class Testing2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int num = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (map.get(a) == null && map.get(b) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(a);
                set.add(b);
                map.put(a, set);
                map.put(b, set);
                num++;
            } else if (map.get(a) != null && map.get(b) == null) {
                map.get(a).add(b);
                map.put(b, map.get(a));
            } else if (map.get(a) == null && map.get(b) != null) {
                map.get(b).add(a);
                map.put(a, map.get(b));
            } else {
                if (map.get(a) == map.get(b)) {
                    continue;
                } else {
                    Set<Integer> temp = map.get(a);
                    temp.addAll(map.get(b));
                    for (int t : temp) {
                        map.put(t, temp);
                    }
                }
            }
        }
        sc.close();
        Set<Set<Integer>> got = new HashSet<>();
        System.out.println(num);
        for (int i = 1; i <= n; i++) {
            if (got.contains(map.get(i))) {
                continue;
            } else {
                Set<Integer> res = map.get(i);
                got.add(res);
                Integer[] iRes = res.toArray(new Integer[res.size()]);
                Arrays.sort(iRes);
                for (int r : iRes) {
                    System.out.print(r + " ");
                }
                System.out.print("\n");
            }
        }
    }
}