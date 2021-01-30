package 程序员面试经典;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 778. 水位上升的泳池中游泳
 * @date: 2021/1/30 12:22 下午
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 * <p>
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * <p>
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[0,2],[1,3]]
 * 输出: 3
 * 解释:
 * 时间为0时，你位于坐标方格的位置为 (0, 0)。
 * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
 * <p>
 * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 * 示例2:
 * <p>
 * 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * 输出: 16
 * 解释:
 * 0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * <p>
 * 最终的路线用加粗进行了标记。
 * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
 *  
 * <p>
 * 提示:
 * <p>
 * 2 <= N <= 50.
 * grid[i][j] 是 [0, ..., N*N - 1] 的排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swim-in-rising-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M778_hard_水位上升的泳池中游泳 {

    /**
     * 解法一
     * 并查集
     * @param grid
     * @return
     */
    /*
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        UnionFind uf = new UnionFind(size);
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = i * n + j;
                list.add(new int[]{num, grid[i][j]});
            }
        }
        Collections.sort(list, Comparator.comparing(o -> o[1]));
        boolean[] inGrid = new boolean[size];
        int max = grid[0][0];
        for (int[] g : list) {
            int i = g[0] / n;
            int j = g[0] % n;
            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n) {
                    continue;
                }
                int next = nextI * n + nextJ;
                if (inGrid[next]) {
                    uf.union(next, g[0]);
                }
            }
            inGrid[g[0]] = true;
            max = Math.max(max, g[1]);
            if (uf.find(0) == uf.find(size - 1)) {
                break;
            }
        }
        return max - grid[0][0];
    }

    class UnionFind {

        int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int key) {
            while (parent[key] != key) {
                parent[key] = parent[parent[key]];
                key = parent[key];
            }
            return key;
        }

        public void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }*/

    /**
     * 方法二
     * Dijkstra
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // 访问记录
        boolean[][] visited = new boolean[n][n];
        // 到节点的距离
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        //构造小顶堆
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(o -> dist[o[0]][o[1]]));
        // 把第一个节点放进去
        minHeap.offer(new int[]{0, 0});
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            int[] point = minHeap.poll();
            int x = point[0];
            int y = point[1];
            //如果已经记录过这个节点了就跳过
            if (visited[x][y]) {
                continue;
            }
            if (x == n - 1 && y == n - 1) {
                return dist[x][y];
            }
            visited[x][y] = true;
            //更新数据
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                    continue;
                }
                if (!visited[newX][newY] && Math.max(dist[x][y], grid[newX][newY]) < dist[newX][newY]) {
                    dist[newX][newY] = Math.max(dist[x][y], grid[newX][newY]);
                    minHeap.offer(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }
}
