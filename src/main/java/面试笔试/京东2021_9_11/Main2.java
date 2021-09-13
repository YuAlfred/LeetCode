package 面试笔试.京东2021_9_11;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/11 7:39 下午
 */
public class Main2 {

    public static int ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        Service[] services = new Service[n];
        for (int i = 0; i < n; i++) {
            int c = in.nextInt();
            List<Integer> related = new LinkedList<>();
            for (int j = 0; j < c; j++) {
                related.add(in.nextInt() - 1);
            }
            services[i] = new Service(false, related);
        }
        // 添加parent
        for (int i = 0; i < services.length; i++) {
            List<Integer> related = services[i].related;
            for (Integer j : related) {
                services[j].parent.add(i);
            }
        }

        for (int i = 0; i < q; i++) {
            boolean state = in.nextInt() == 1;
            int id = in.nextInt() - 1;
            changeStates(services, id, state);
            System.out.println(ans);
        }
        in.close();
    }

    public static void changeStates(Service[] services, int id, boolean state) {
        if (services[id].status == state) {
            return;
        }
        if (state) {
            services[id].status = state;
            ans++;
            List<Integer> related = services[id].related;
            for (Integer i : related) {
                changeStates(services, i, state);
            }
        } else {
            services[id].status = state;
            ans--;
            Set<Integer> parents = services[id].parent;
            for (Integer i : parents) {
                changeStates(services, i, state);
            }
        }
    }

    static class Service {

        boolean status;

        List<Integer> related;
        Set<Integer> parent;

        public Service(boolean status, List<Integer> related) {
            this.status = status;
            this.related = related;
            parent = new HashSet<>();
        }
    }

}
