package 面试笔试.华为2021_9_8;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/8 7:35 下午
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        Map<String, Node> map = new HashMap<>();
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] ss = s.split(",");
            String name = ss[0];
            int time = Integer.parseInt(ss[1]);
            List<String> depends = Arrays.asList(ss).subList(2, ss.length);
            map.put(name, new Node(name, time, depends));
        }
        in.close();

        Map<String, Long> timesNeed = new HashMap<>();
        Set<String> visited = new HashSet<>();


        long ans = dfs(map, target, timesNeed, visited);
        System.out.println(ans);

    }

    public static long dfs(Map<String, Node> map, String target, Map<String, Long> timesNeed, Set<String> visited) {
        if (target.isEmpty()) {
            return 0;
        }
        if (timesNeed.containsKey(target)) {
            return timesNeed.get(target);
        }
        if (!map.containsKey(target)) {
            return -1;
        }
        if (visited.contains(target)) {
            return -1;
        } else {
            visited.add(target);
        }

        long waitTime = 0;
        Node cur = map.get(target);
        for (String depend : cur.depends) {
            long need = dfs(map, depend, timesNeed, visited);
            if (need == -1) {
                timesNeed.put(depend, -1L);
                return -1;
            } else {
                waitTime = Math.max(need, waitTime);
            }
        }

        timesNeed.put(target, waitTime + cur.time);
        return waitTime + cur.time;
    }

    public static class Node {

        String name;
        long time;
        List<String> depends;

        public Node(String name, long time, List<String> depends) {
            this.name = name;
            this.time = time;
            this.depends = depends;
        }
    }

}
