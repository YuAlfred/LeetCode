package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 765. 情侣牵手
 * @date: 2021/2/15 10:13 上午
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 * <p>
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * <p>
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 示例 2:
 * <p>
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * 说明:
 * <p>
 * len(row) 是偶数且数值在 [4, 60]范围内。
 * 可以保证row 是序列 0...len(row)-1 的一个全排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M765_hard_情侣牵手 {

    public int minSwapsCouples(int[] row) {
        UnionFind uf = new UnionFind(row.length);
        for (int i = 0; i < row.length; i += 2) {
            uf.union(row[i] | 1, row[i + 1] | 1);
        }
        int res = 0;
        for (int i = 1; i < row.length; i += 2) {
            if (uf.find(i) == i) {
                res += (uf.size[i] - 1);
            }
        }
        return res;
    }

    class UnionFind {

        int[] parent;
        int[] size;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.size = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                this.size[i] = 1;
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
                size[rootB] += size[rootA];
            }
        }
    }
}
