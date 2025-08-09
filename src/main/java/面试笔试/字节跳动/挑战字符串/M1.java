package 面试笔试.字节跳动.挑战字符串;

/**
 * @author : ty
 * @version : 无重复字符的最长子串
 * @date : Created in 2020/6/7 15:46
 * @description : 1.0.0
 * @modified By  :
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class M1 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int[] flag = new int[256];

        int length = 0;
        int tempLength = 0;

        for (int i = 0, j = 0; j < s.length(); ) {

            char a = s.charAt(j);

            if (flag[a] == 0) {
                j++;
                flag[a] = 1;
                tempLength++;
                if (tempLength > length) {
                    length = tempLength;
                }
            } else {
                while (flag[a] == 1 && i <= j) {
                    flag[s.charAt(i)] = 0;
                    i++;
                    tempLength--;
                }
            }
        }

        return length;

    }


}
