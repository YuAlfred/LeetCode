package 面试笔试.美团21_8_8;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/8/8 11:28 上午
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            input[i][0] = in.nextInt();
            input[i][1] = in.nextInt();
        }
        int[] exchange = new int[m];
        for (int i = 0; i < m; i++) {
            exchange[i] = in.nextInt();
        }
        in.close();

        List<Integer> tree = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                tree.add(node);
                if (node == 0) {
                    continue;
                }
                queue.add(input[node - 1][0]);
                queue.add(input[node - 1][1]);
            }
        }

        int[] treeInt = tree.stream().mapToInt(Integer::intValue).toArray();

        // 调换
        for (int i : exchange) {
            exchange(treeInt, i - 1);
        }

        dfs(treeInt, 0);

    }

    public static void dfs(int[] tree, int i) {
        int left = (i + 1) * 2 - 1;
        int right = left + 1;
        if (tree[left] != 0) {
            dfs(tree, left);
        }
        System.out.print(tree[i] + " ");
        if (tree[right] != 0) {
            dfs(tree, right);
        }
    }

    public static void exchange(int[] tree, int i) {
        int left = (i + 1) * 2 - 1;
        int right = left + 1;
        int temp = tree[left];
        tree[left] = tree[right];
        tree[right] = temp;
    }
}
