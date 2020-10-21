package 程序员面试经典;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 16.20. T9键盘
 * @date: 2020/10/21 11:32 上午
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * 示例 2:
 * <p>
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * 提示：
 * <p>
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/t9-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_20_middle_T9键盘 {

    public static void main(String[] args) {
        M16_20_middle_T9键盘 m = new M16_20_middle_T9键盘();
        m.getValidT9Words("8733", new String[]{"tree", "used"});
    }

    class WordsTree {
        WordsTree[] next;
        boolean isWorld;

        public WordsTree() {
            next = new WordsTree[26];
            isWorld = false;
        }
    }


    public List<String> getValidT9Words(String num, String[] words) {
        WordsTree head = new WordsTree();
        for (String s : words) {
            WordsTree cur = head;
            for (char a : s.toCharArray()) {
                if (cur.next[(a - 'a')] == null) {
                    WordsTree t = new WordsTree();
                    cur.next[(a - 'a')] = t;
                }
                cur = cur.next[(a - 'a')];
            }
            cur.isWorld = true;
        }
        List<String> res = new LinkedList<>();
        dfs(res, "", head, num, 0);
        return res;
    }

    public void dfs(List<String> res, String path, WordsTree cur, String num, int i) {
        if (cur == null || i > num.length()) {
            return;
        } else if (i == num.length()) {
            if (cur.isWorld) {
                res.add(path);
            }
            return;
        }
        switch (num.charAt(i)) {
            case '2': {
                dfs(res, path + "a", cur.next[0], num, i + 1);
                dfs(res, path + "b", cur.next[1], num, i + 1);
                dfs(res, path + "c", cur.next[2], num, i + 1);
                break;
            }
            case '3': {
                dfs(res, path + "d", cur.next[3], num, i + 1);
                dfs(res, path + "e", cur.next[4], num, i + 1);
                dfs(res, path + "f", cur.next[5], num, i + 1);
                break;
            }
            case '4': {
                dfs(res, path + "g", cur.next[6], num, i + 1);
                dfs(res, path + "h", cur.next[7], num, i + 1);
                dfs(res, path + "i", cur.next[8], num, i + 1);
                break;
            }
            case '5': {
                dfs(res, path + "j", cur.next[9], num, i + 1);
                dfs(res, path + "k", cur.next[10], num, i + 1);
                dfs(res, path + "l", cur.next[11], num, i + 1);
                break;
            }
            case '6': {
                dfs(res, path + "m", cur.next[12], num, i + 1);
                dfs(res, path + "n", cur.next[13], num, i + 1);
                dfs(res, path + "o", cur.next[14], num, i + 1);
                break;
            }
            case '7': {
                dfs(res, path + "p", cur.next[15], num, i + 1);
                dfs(res, path + "q", cur.next[16], num, i + 1);
                dfs(res, path + "r", cur.next[17], num, i + 1);
                dfs(res, path + "s", cur.next[18], num, i + 1);
                break;
            }
            case '8': {
                dfs(res, path + "t", cur.next[19], num, i + 1);
                dfs(res, path + "u", cur.next[20], num, i + 1);
                dfs(res, path + "v", cur.next[21], num, i + 1);
                break;
            }
            case '9': {
                dfs(res, path + "w", cur.next[22], num, i + 1);
                dfs(res, path + "x", cur.next[23], num, i + 1);
                dfs(res, path + "y", cur.next[24], num, i + 1);
                dfs(res, path + "z", cur.next[25], num, i + 1);
                break;
            }
        }
    }
}










