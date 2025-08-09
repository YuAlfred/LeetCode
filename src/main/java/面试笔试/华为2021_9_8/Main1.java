package 面试笔试.华为2021_9_8;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/8 6:36 下午
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(in.nextInt());
        }
        for (int i = 0; i < n - 1; i++) {
            Node parent = nodes[in.nextInt()];
            Node son = nodes[in.nextInt()];
            if (parent.left == null) {
                parent.left = son;
            } else {
                parent.right = son;
            }
        }
        in.close();

        Node root = nodes[0];
        dfs(root);

        int ans = 0;
        int diff = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            if (Math.abs((root.total - nodes[i].total) - nodes[i].total) > diff) {
                diff = Math.abs((root.total - nodes[i].total) - nodes[i].total);
                ans = i;
            }
        }
        System.out.println(ans);

    }

    public static int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        root.total = dfs(root.left) + dfs(root.right) + root.val;
        return root.total;
    }

    public static class Node {

        int val;
        Node left;
        Node right;
        int total;

        public Node(int val) {
            this.val = val;
        }
    }


}
