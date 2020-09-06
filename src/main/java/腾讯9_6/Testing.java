package 腾讯9_6;



/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


import java.util.*;
public class Testing {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Map<Integer, Set<Integer>> map = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int[] team = new int[in.nextInt()];
            for (int j = 0; j < team.length; j++) {
                team[j] = in.nextInt();
            }
            for (int j = 0; j < team.length; j++) {
                for (int k = 0; k < team.length; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (map.containsKey(team[j])) {
                        map.get(team[j]).add(team[k]);
                    } else {
                        Set<Integer> tempSet = new HashSet<>();
                        tempSet.add(team[k]);
                        map.put(team[j], tempSet);
                    }
                }
            }
        }
        in.close();
        boolean[] visited = new boolean[n + 1];
        System.out.println(visit(visited, 0, map));
    }

    public static int visit(boolean[] visited, int x, Map<Integer, Set<Integer>> map) {
        if (visited[x]) {
            return 0;
        }
        visited[x] = true;
        Set<Integer> team = map.get(x);
        int res = 1;
        if (team != null) {
            for (int i : team) {
                res += visit(visited, i, map);
            }
        }
        return res;
    }
}