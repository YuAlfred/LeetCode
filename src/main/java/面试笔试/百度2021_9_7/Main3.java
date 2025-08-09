package 面试笔试.百度2021_9_7;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/7 7:31 下午
 */
public class Main3 {

    public static int[] charCount = new int[26];
    public static int letterCount = 0;
    public static int mod = (int) 1e9 + 7;
    public static int ans = 0;

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        in.close();

        char[] cs = s.toCharArray();
        dfs(cs, 0, k);
        System.out.println(ans);

    }

    public static void dfs(char[] cs, int i, int k) {
        if (i >= cs.length || letterCount > k) {
            return;
        }
        // 不取
        dfs(cs, i + 1, k);

        // 取
        charCount[cs[i] - 'a']++;
        if (charCount[cs[i] - 'a'] == 1) {
            letterCount++;
        }
        if (letterCount == k) {
            ans++;
            ans %= mod;
        }
        dfs(cs, i + 1, k);
        charCount[cs[i] - 'a']--;
        if (charCount[cs[i] - 'a'] == 0) {
            letterCount--;
        }
    }


}
