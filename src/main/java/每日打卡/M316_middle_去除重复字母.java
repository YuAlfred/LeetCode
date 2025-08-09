package 每日打卡;

import lombok.val;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 316. 去除重复字母
 * @date: 2020/12/20 8:18 下午
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M316_middle_去除重复字母 {

    public static void main(String[] args) {
        val m = new M316_middle_去除重复字母();
        System.out.println(m.removeDuplicateLetters("bbcaac"));
    }

    public String removeDuplicateLetters(String s) {
        int[] lastTime = new int[26];
        boolean[] isInQueue = new boolean[26];
        Deque<Character> deque = new LinkedList<>();

        for (char a : s.toCharArray()) {
            lastTime[a - 'a']++;
        }

        for (char a : s.toCharArray()) {
            int i = a - 'a';
            if (!deque.isEmpty()) {
                if (isInQueue[i]) {
                    lastTime[i]--;
                    continue;
                }
                while (!deque.isEmpty() && a < deque.peekFirst()) {
                    if (lastTime[deque.peekFirst() - 'a'] <= 0) {
                        break;
                    }
                    char f = deque.peekFirst();
                    isInQueue[f - 'a'] = false;
                    deque.pollFirst();
                }
            }
            deque.push(a);
            lastTime[i]--;
            isInQueue[i] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char a : deque) {
            sb.insert(0, a);
        }
        return sb.toString();
    }

}














