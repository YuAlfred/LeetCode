package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 959. 由斜杠划分区域
 * @date: 2021/1/25 10:31 上午
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 * <p>
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * <p>
 * 返回区域的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * [
 *   " /",
 *   "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 * <p>
 * 示例 4：
 * <p>
 * 输入：
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 * <p>
 * 示例 5：
 * <p>
 * 输入：
 * [
 *   "//",
 *   "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] 是 '/'、'\'、或 ' '。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M959_middle_由斜杠划分区域 {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < n; i++) {
            String row = grid[i];
            for (int j = 0; j < n; j++) {
                char c = row.charAt(j);
                int num = (i * n + j) * 4;
                if (c == ' ') {
                    uf.union(num, num + 1);
                    uf.union(num + 1, num + 2);
                    uf.union(num + 2, num + 3);
                } else if (c == '\\') {
                    uf.union(num + 2, num + 3);
                    uf.union(num, num + 1);
                } else {
                    uf.union(num + 1, num + 2);
                    uf.union(num, num + 3);
                }

                if (j < n - 1) {
                    uf.union(num + 1, num + 7);
                }
                if (i < n - 1) {
                    uf.union(num + 2, ((i + 1) * n + j) * 4);
                }
            }
        }
        return uf.unionSize;
    }


    class UnionFind {
        int[] parent;
        int unionSize;

        public UnionFind(int size) {
            unionSize = size;
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
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parent[rootA] = rootB;
                unionSize--;
            }
        }
    }
}



