package 最小连通图;

/**
 * @ Author     ：ty
 * @ Date       ：Created in 2019/4/9 16:58
 * @ Description：最小连通图算法（Dijkstra变种）
 * @ Modified By：
 * @ Version:     1.0
 */
public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        int[][] graph = {{0, 0, 0, 5, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {0, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                        Integer.MAX_VALUE}, {0, 0, 0, Integer.MAX_VALUE, 6, 7, Integer.MAX_VALUE},
                {5, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 4, Integer.MAX_VALUE, 2},
                {3, Integer.MAX_VALUE, 6, 4, 0, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, 0, 0, 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 1,
                        0}

        };
        app.minRoot(graph);

    }


    /**
     * 计算最小连通图算法
     *
     * @param graph 邻接矩阵
     * @return 返回加权总值
     */
    public int minRoot(int[][] graph) {
        //存储节点是否已经被最小连通
        int[] visited = new int[graph.length];
        //enabled存储边是否被启用
        int[][] enabled = getEnabled(graph);
        //从0点开始找
        visited[0] = 1;
        findMin(graph, enabled, visited);
        printArray(graph);
        System.out.println("--------------");
        printArray(enabled);
        return 0;
    }

    public int[][] getEnabled(int[][] graph) {
        int length = graph.length;
        int[][] enabled = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (graph[i][j] == 0) {
                    enabled[i][j] = 1;
                } else {
                    enabled[i][j] = 0;
                }
            }
        }
        return enabled;
    }

    public void findMin(int[][] graph, int[][] enabled, int[] visited) {
        int length = graph.length;
        //如果已经全部划入最小联通图，则停止寻找
        if (isAllVisited(visited)) {
            return;
        }
        //开始找下一个点接纳入最小连通图
        //本轮找到的最小加权及此线的位置
        int shortest = Integer.MAX_VALUE;
        int[] position = {0, 0};
        //遍历每个顶点
        for (int i = 0; i < length; i++) {
            //如果顶点已在最小联通图，遍历它的边
            if (visited[i] == 1) {
                for (int j = 0; j < length; j++) {
                    //只找通向非连通地区的边
                    if (visited[j] == 0 && graph[i][j] < shortest) {
                        shortest = graph[i][j];
                        position[0] = i;
                        position[1] = j;
                    }
                }
            }
        }
        //完成后将点和边加入连通区
        visited[position[1]] = 1;
        enabled[position[0]][position[1]] = 2;
        //继续下一次寻找
        findMin(graph, enabled, visited);

    }

    /**
     * 判断数组是否全非零
     *
     * @param visited 数组存储节点是否已经被划入最小联通图
     * @return boolean
     */
    public boolean isAllVisited(int[] visited) {
        for (int i : visited) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    public void printArray(int[][] array) {
        for (int[] i : array) {
            for (int j : i) {
                if (j == Integer.MAX_VALUE) {
                    System.out.print("* ");
                } else {
                    System.out.print(j + " ");
                }

            }
            System.out.println();
        }
    }
}
