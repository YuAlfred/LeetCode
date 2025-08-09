package 面试笔试.华为模拟笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/7 3:15 下午
 */
public class Main3 {

    public static int ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        char[] cs = s.toCharArray();
        Arrays.sort(cs);

        dfs(cs, 0);
        System.out.println(ans);

    }

    public static void dfs(char[] cs, int index) {
        if (index >= cs.length) {
            ans++;
            return;
        }
        boolean[] visited = new boolean[26];
        for (int i = index; i < cs.length; i++) {
            if (visited[cs[i] - 'A']) {
                continue;
            } else {
                visited[cs[i] - 'A'] = true;
            }
            swap(cs, i, index);
            dfs(cs, index + 1);
            swap(cs, i, index);
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }


}
