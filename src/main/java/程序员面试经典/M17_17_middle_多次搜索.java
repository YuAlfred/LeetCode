package 程序员面试经典;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/25 6:28 下午
 * @description : 面试题 17.17. 多次搜索
 * @modified By  :
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * 提示：
 * <p>
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multi-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_17_middle_多次搜索 {

    class Trie {
        public Trie[] childes;
        public boolean isWorld;
        public List<Integer> res;

        public Trie() {
            this.childes = new Trie[26];
            this.isWorld = false;
            res = new LinkedList<>();
        }
    }


    public int[][] multiSearch(String big, String[] smalls) {
        Trie root = new Trie();
        for (String s : smalls) {
            Trie cur = root;
            for (char a : s.toCharArray()) {
                int i = a - 'a';
                if (cur.childes[i] == null) {
                    cur.childes[i] = new Trie();
                }
                cur = cur.childes[i];
            }
            cur.isWorld = true;
        }
        for (int i = 0; i < big.length(); i++) {
            Trie cur = root;
            for (int j = i; j < big.length(); j++) {
                char a = big.charAt(j);
                int c = a - 'a';
                if (cur.childes[c] == null) {
                    break;
                } else {
                    if (cur.childes[c].isWorld) {
                        cur.childes[c].res.add(i);
                    }
                }
                cur = cur.childes[c];
            }
        }
        int[][] result = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            String s = smalls[i];
            Trie cur = root;
            for (char a : s.toCharArray()) {
                int j = a - 'a';
                cur = cur.childes[j];
            }
            result[i] = cur.res.stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }


}









