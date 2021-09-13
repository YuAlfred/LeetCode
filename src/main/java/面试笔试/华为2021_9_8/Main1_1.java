package 面试笔试.华为2021_9_8;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/8 6:36 下午
 */
public class Main1_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(in.nextInt());
        }
        // todo 找根节点
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            Node parent = nodes[in.nextInt()];
            int sonP = in.nextInt();
            Node son = nodes[sonP];
            visited[sonP] = true;
            if (parent.left == null) {
                parent.left = son;
            } else {
                parent.right = son;
            }
        }
        in.close();

        Node root = nodes[0];
        int rootI = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                root = nodes[i];
                rootI = i;
                break;
            }
        }
        dfs(root);

        int ans = 0;
        long diff = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i == rootI) {
                continue;
            }
            if (Math.abs((root.total - nodes[i].total) - nodes[i].total) > diff) {
                diff = Math.abs((root.total - nodes[i].total) - nodes[i].total);
                ans = i;
            }
        }
        System.out.println(ans);

    }

    public static long dfs(Node root) {
        if (root == null) {
            return 0;
        }
        root.total = dfs(root.left) + dfs(root.right) + root.val;
        return root.total;
    }

    public static class Node {

        long val;
        Node left;
        Node right;
        long total;

        public Node(int val) {
            this.val = val;
        }
    }


}
