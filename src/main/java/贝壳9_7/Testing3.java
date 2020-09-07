package 贝壳9_7;


/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Testing3 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[][] subject = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                subject[i][j] = s.charAt(j) == '1';
            }
        }
        in.close();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < m; i++) {
            int temp = -1;
            for (int j = 0; j < n; j++) {
                if (subject[j][i]) {
                    if (temp == -1) {
                        temp = j;
                    } else {
                        union(parent, temp, j);
                    }
                }
            }
        }
        int times = 0;
        boolean allZero = true;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                times++;
            }
            if (allZero) {
                for (boolean b : subject[i]) {
                    if (b) {
                        allZero = false;
                        break;
                    }
                }
            }
        }
        if (allZero) {
            times++;
        }
        System.out.println(times - 1);
    }


    public static int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    public static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
}