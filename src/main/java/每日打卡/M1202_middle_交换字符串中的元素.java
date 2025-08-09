package 每日打卡;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1202. 交换字符串中的元素
 * @date: 2021/1/11 2:45 下午
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * <p>
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 * <p>
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1202_middle_交换字符串中的元素 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (List<Integer> pair : pairs) {
            int i = pair.get(0);
            int j = pair.get(1);
            union(parent, i, j);
        }
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            int root = findRoot(parent, i);
            if (!map.containsKey(root)) {
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.add(a);
                map.put(root, queue);
            } else {
                map.get(root).add(a);
            }
        }
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int root = findRoot(parent, i);
            res[i] = map.get(root).poll();
        }
        return String.valueOf(res);
    }

    public int findRoot(int[] patent, int key) {
        while (patent[key] != key) {
            patent[key] = patent[patent[key]];
            key = patent[key];
        }
        return key;
    }

    public void union(int[] parent, int i, int j) {
        parent[findRoot(parent, i)] = findRoot(parent, j);
    }

}
