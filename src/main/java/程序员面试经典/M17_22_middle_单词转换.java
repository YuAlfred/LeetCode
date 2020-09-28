package 程序员面试经典;

import java.util.*;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/28 10:28 上午
 * @description : 面试题 17.22. 单词转换
 * @modified By  :
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 * <p>
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-transformer-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_22_middle_单词转换 {

    public static void main(String[] args) {
        M17_22_middle_单词转换 m = new M17_22_middle_单词转换();
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        m.findLadders("hit", "cog", wordList);
    }


    List<String> wordList;
    boolean[] marked;
    List<String> output;
    String endWord;
    List<String> result;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList;
        output = new ArrayList();
        marked = new boolean[wordList.size()];
        result = new ArrayList();
        this.endWord = endWord;
        dfs(beginWord);
        return result;
    }

    public void dfs(String s) {
        output.add(s);
        Queue<String> queue = oneCharDiff(s);
        for (String str : queue) {
            if (str.equals(endWord)) {
                output.add(str);
                result = new ArrayList(output);
                return;
            }
            dfs(str);
            output.remove(output.size() - 1);
        }

    }

    public Queue<String> oneCharDiff(String s) {
        Queue<String> queue = new LinkedList();
        for (int j = 0; j < wordList.size(); j++) {
            String str = wordList.get(j);
            int diffNum = 0;
            if (str.length() != s.length() || marked[j]) continue;
            for (int i = 0; i < str.length(); i++) {
                if (diffNum >= 2) break;
                if (str.charAt(i) != s.charAt(i)) diffNum++;
            }
            if (diffNum == 1) {
                queue.add(str);
                marked[j] = true;
            }
        }
        return queue;
    }
}





