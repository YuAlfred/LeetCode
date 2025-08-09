package LeetCode比赛.第400周赛;

import java.util.*;

/**
 * @author alfred
 * @version 1.0.0
 * @date: 2024/6/3 00:18
 * @description: 给你一个字符串 s 。它可能包含任意数量的 '*' 字符。你的任务是删除所有的 '*' 字符。
 * <p>
 * 当字符串还存在至少一个 '*' 字符时，你可以执行以下操作：
 * <p>
 * 删除最左边的 '*' 字符，同时删除该星号字符左边一个字典序 最小 的字符。如果有多个字典序最小的字符，你可以删除它们中的任意一个。
 * 请你返回删除所有 '*' 字符以后，剩余字符连接而成的 字典序最小 的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaba*"
 * <p>
 * 输出："aab"
 * <p>
 * 解释：
 * <p>
 * 删除 '*' 号和它左边的其中一个 'a' 字符。如果我们选择删除 s[3] ，s 字典序最小。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abc"
 * <p>
 * 输出："abc"
 * <p>
 * 解释：
 * <p>
 * 字符串中没有 '*' 字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只含有小写英文字母和 '*' 字符。
 * 输入保证操作可以删除所有的 '*' 字符。
 */
public class M100322_删除星号以后字典序最小的字符串 {

    public void pop(Deque<Integer>[] stacks) {
        for (int i = 0; i < 26; i++) {
            if (!stacks[i].isEmpty()) {
                stacks[i].pop();
                return;
            }
        }
    }

    public String clearStars(String s) {
        Deque<Integer>[] stacks = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            stacks[i] = new LinkedList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '*') {
                stacks[c - 'a'].push(i);
            }else {
                pop(stacks);
            }
        }

        List<Integer> ans_index = new LinkedList<>();
        for (Deque<Integer> stack : stacks) {
            ans_index.addAll(stack);
        }

        Collections.sort(ans_index);

        StringBuilder sb = new StringBuilder();
        for (int index : ans_index) {
            sb.append(s.charAt(index));
        }

        return sb.toString();
    }
}
