package 面试笔试.字节2021_10_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/10/17 7:07 下午
 */
public class Main3 {

    public static List<String> ans;
    public static int POINT = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String locks = in.next();
        in.close();
        List<String> path = new ArrayList<>();
        dfs(locks, 0, path, 0, 'Z');
        StringBuilder res = new StringBuilder(ans.get(0));
        for (int i = 1; i < ans.size(); i++) {
            res.append("->");
            res.append(ans.get(i));
        }
        System.out.println(res);
    }

    public static void dfs(String locks, int index, List<String> path, int point, char curKey) {
        if (index >= locks.length()) {
            if (point > POINT) {
                ans = new ArrayList<>(path);
                POINT = point;
            }
            return;
        }
        char curLock = locks.charAt(index);
        // 取
        if (curKey >= curLock) {
            path.add(String.valueOf(index + 1));
            dfs(locks, index + 1, path, point + 1, curLock);
            path.remove(path.size() - 1);
        }
        // 不取
        dfs(locks, index + 1, path, point, curKey);
    }

}
