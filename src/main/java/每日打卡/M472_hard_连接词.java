package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 472. 连接词
 * @date: 2021/12/28 5:21 PM
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * <p>
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 * "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 * "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 * 示例 2：
 * <p>
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 0 <= words[i].length <= 1000
 * words[i] 仅由小写字母组成
 * 0 <= sum(words[i].length) <= 105
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/concatenated-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M472_hard_连接词 {

    public static void main(String[] args) {
        M472_hard_连接词 m = new M472_hard_连接词();
        m.findAllConcatenatedWordsInADict(new String[]{"cat", "cats"});
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // 先生成字典数
        Trie root = new Trie();
        for (String word : words) {
            buildTrie(root, word);
        }
        List<String> ans = new LinkedList<>();
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            char[] cWord = word.toCharArray();
            if (dfs(root, cWord, 0, new boolean[cWord.length])) {
                ans.add(word);
            }
        }
        return ans;
    }

    // 记忆化递归
    public boolean dfs(Trie root, char[] word, int index, boolean[] visited) {
        if (index == word.length) {
            return true;
        }
        if (visited[index]) {
            return false;
        }
        Trie cur = root;
        for (int i = index; i < word.length; i++) {
            if (cur.next[word[i] - 'a'] == null) {
                visited[index] = true;
                return false;
            }
            cur = cur.next[word[i] - 'a'];
            if (cur.isWord) {
                if (index == 0 && i == word.length - 1) {
                    visited[index] = true;
                    return false;
                }
                if (dfs(root, word, i + 1, visited)) {
                    return true;
                }
            }
        }
        visited[index] = true;
        return false;
    }


    public void buildTrie(Trie root, String word) {
        for (char c : word.toCharArray()) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new Trie();
            }
            root = root.next[c - 'a'];
        }
        root.isWord = true;
    }

    class Trie {
        boolean isWord;
        Trie[] next;

        public Trie() {
            this.isWord = false;
            this.next = new Trie[26];
        }
    }


}
