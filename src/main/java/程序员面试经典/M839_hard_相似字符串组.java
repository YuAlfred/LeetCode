package 程序员面试经典;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 839. 相似字符串组
 * @date: 2021/1/31 9:00 上午
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * <p>
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * <p>
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * <p>
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 1000
 * sum(strs[i].length) <= 2 * 104
 * strs[i] 只包含小写字母。
 * strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 *  
 * <p>
 * 备注：
 * <p>
 *       字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/similar-string-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M839_hard_相似字符串组 {

    public int numSimilarGroups(String[] strs) {
        int size = 0;
        Map<String, Integer> stringToInt = new HashMap<>();
        for (String s : strs) {
            if (!stringToInt.containsKey(s)) {
                stringToInt.put(s, size++);
            }
        }
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < strs.length; i++) {
            //遍历其他
            for (int j = i + 1; j < strs.length; j++) {
                if (canSwap(strs[i], strs[j])) {
                    uf.union(stringToInt.get(strs[i]), stringToInt.get(strs[j]));
                }
            }
        }
        return uf.size;
    }

    public boolean canSwap(String a, String b) {
        int diffCount = 0;
        char[] difA = new char[2];
        char[] difB = new char[2];
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (ca != cb) {
                diffCount++;
                if (diffCount > 2) {
                    return false;
                }
                difA[diffCount - 1] = ca;
                difB[diffCount - 1] = cb;
            }
        }
        if (difA[0] == difB[1] && difA[1] == difB[0]) {
            return true;
        }
        return false;
    }

    class UnionFind {
        int[] parent;
        int size;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            this.size = size;
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
                size--;
                parent[rootA] = rootB;
            }
        }
    }

}
