package 程序员面试经典;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/25 10:29 上午
 * @description : 面试题 17.15. 最长单词
 * @modified By  :
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 * <p>
 * 示例：
 * <p>
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 * 提示：
 * <p>
 * 0 <= len(words) <= 200
 * 1 <= len(words[i]) <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_15_middle_最长单词 {

    public static void main(String[] args) {
        M17_15_middle_最长单词 m = new M17_15_middle_最长单词();
        m.longestWord(new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"});
    }

    class TreeNode {
        public TreeNode[] childes;
        public boolean isWord;

        public TreeNode() {
            this.childes = new TreeNode[26];
            this.isWord = false;
        }
    }

    TreeNode root = new TreeNode();

    public String longestWord(String[] words) {
        for (String s : words) {
            TreeNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.childes[c - 'a'] == null) {
                    cur.childes[c - 'a'] = new TreeNode();
                }
                cur = cur.childes[c - 'a'];
            }
            cur.isWord = true;
        }
        int maxLength = 0;
        String res = "";
        for (String s : words) {
            change(s);
            if (contains(s)) {
                if (s.length() > maxLength) {
                    maxLength = s.length();
                    res = s;
                } else if (s.length() == maxLength) {
                    if (res.compareTo(s) > 0) {
                        res = s;
                    }
                }
            }
            change(s);
        }
        return res;
    }

    public boolean contains(String word) {
        if (word.isEmpty()) {
            return true;
        }
        boolean res = false;
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (cur.childes[a - 'a'] == null) {
                return false;
            } else if (cur.childes[a - 'a'].isWord) {
                res = contains(word.substring(i + 1));
                if (res) {
                    return true;
                }
            }
            cur = cur.childes[a - 'a'];
        }
        return res;
    }

    public void change(String word) {
        TreeNode cur = root;
        for (char a : word.toCharArray()) {
            cur = cur.childes[a - 'a'];
        }
        cur.isWord = !cur.isWord;
    }
}