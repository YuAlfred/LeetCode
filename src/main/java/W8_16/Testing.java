package W8_16;

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
        int n = in.nextInt();
        int m = in.nextInt();
        PriorityQueue<Integer> a = new PriorityQueue();
        Integer[][] client = new Integer[m][2];
        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }
        for (int i = 0; i < m; i++) {
            client[i][0] = in.nextInt();
            client[i][1] = in.nextInt();
        }
        in.close();

        Arrays.sort(client, (o1, o2) -> o2[1] - o1[1]);

        int j = 0;
        int count = 0;
        while (j < client.length && a.size() > 0) {
            boolean add = true;
            Iterator<Integer> it = a.iterator();
            while (it.hasNext()) {
                if (it.next() >= client[j][0]) {
                    count += client[j][1];
                    j++;
                    it.remove();
                    add = false;
                    break;
                }
            }
            if (add) {
                j++;
            }
        }
        System.out.println(count);
    }
}
