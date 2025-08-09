package 程序员面试经典;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/24 9:49 下午
 * @description : 面试题 17.13. 恢复空格
 * @modified By  :
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_13_middle_恢复空格 {

    public static void main(String[] args) {

        //
        // respace(new String[]{"looked", "just", "like", "her", "brother"},
        //     "jesslookedjustliketimherbrother");
    }

    public class TreeNode {
        TreeNode[] childs;
        boolean isWord;

        public TreeNode() {
            this.childs = new TreeNode[26];
            this.isWord = false;
        }
    }

    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[sentence.length() + 1];
        dp[sentence.length()] = 0;
        TreeNode root = new TreeNode();
        for (String s : dictionary) {
            TreeNode cur = root;
            for (char a : s.toCharArray()) {
                if (cur.childs[a - 'a'] == null) {
                    cur.childs[a - 'a'] = new TreeNode();
                }
                cur = cur.childs[a - 'a'];
            }
            cur.isWord = true;
        }
        for (int i = sentence.length() - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            TreeNode cur = root;
            for (int j = i; j < sentence.length(); j++) {
                int c = sentence.charAt(j) - 'a';
                if (cur.childs[c] == null) {
                    break;
                } else {
                    if (cur.childs[c].isWord) {
                        dp[i] = Math.min(dp[j + 1], dp[i]);
                    }
                }
                cur = cur.childs[c];
            }
        }
        return dp[0];
    }

}










