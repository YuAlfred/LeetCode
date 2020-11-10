package 程序员面试经典;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.25. 单词矩阵
 * @date: 2020/11/6 9:51 上午
 * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
 * <p>
 * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
 * 输出:
 * [
 *    "this",
 *    "real",
 *    "hard"
 * ]
 * 示例 2:
 * <p>
 * 输入: ["aa"]
 * 输出: ["aa","aa"]
 * 说明：
 * <p>
 * words.length <= 1000
 * words[i].length <= 100
 * 数据保证单词足够随机
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-rectangle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_25_hard_单词矩阵 {

    class Trie {
        Trie[] children;
        boolean isWord;

        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }

    public String[] maxRectangle(String[] words) {
        if (words.length == 0) {
            return new String[0];
        }
        int minLength = words[0].length();
        int maxLength = words[0].length();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : words) {
            map.computeIfAbsent(s.length(), k -> new LinkedList<>());
            map.get(s.length()).add(s);
        }
        for (int i = minLength; i <= maxLength; i++) {
            //构造字典数
            List<String> dic = map.get(i);
            Trie root = new Trie();
            for (String s : dic) {
                Trie cur = root;
                for (char a : s.toCharArray()) {
                    if (cur.children[a - 'a'] == null) {
                        cur.children[a - 'a'] = new Trie();
                    }
                    cur = cur.children[a - 'a'];
                }
                cur.isWord = true;
            }
            List<String> result = new LinkedList<>();

        }
        return null;
    }

    // public boolean isValid(Trie root, List<String> res) {
    //
    // }
}
















