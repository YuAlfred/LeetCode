package 每日打卡;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 140. 单词拆分 II
 * @date: 2020/11/2 9:46 上午
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M140_hard_单词拆分_II {

    public static void main(String[] args) {
        M140_hard_单词拆分_II m = new M140_hard_单词拆分_II();
        List<String> words = new LinkedList<>();
        String[] sWords = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        words.addAll(Arrays.asList(sWords));
        List<String> res = m.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            words);
    }


    static class Words {
        Words[] next;
        boolean isWord;

        public Words() {
            next = new Words[26];
            isWord = false;
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Words root = new Words();
        for (String i : wordDict) {
            Words cur = root;
            for (char a : i.toCharArray()) {
                int index = a - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Words();
                }
                cur = cur.next[index];
            }
            cur.isWord = true;
        }
        List<String>[] dp = new List[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            find(root, s, i, dp);
        }
        return dp[0];
    }

    public List<String> find(Words root, String s, int index, List<String>[] dp) {
        List<String> res = new LinkedList<>();
        if (index >= s.length()) {
            res.add("");
            return res;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        Words cur = root;
        for (int i = index; i < s.length(); i++) {
            int p = s.charAt(i) - 'a';
            if (cur.next[p] == null) {
                break;
            }
            cur = cur.next[p];
            if (cur.isWord) {
                List<String> temp = find(root, s, i + 1, dp);
                for (String t : temp) {
                    if (t.isEmpty()){
                        res.add(s.substring(index, i + 1));
                    }else {
                        res.add(s.substring(index, i + 1) + " " + t);
                    }
                }
            }
        }
        dp[index] = res;
        return res;
    }
}













