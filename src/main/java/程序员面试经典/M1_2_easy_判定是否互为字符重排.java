package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/8 5:19 下午
 * @description : 面试题 01.02. 判定是否互为字符重排
 * @modified By  :
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1_2_easy_判定是否互为字符重排 {

    public boolean CheckPermutation(String s1, String s2) {
        int[] t1 = times(s1);
        int[] t2 = times(s2);
        for (int i = 0; i < 26; i++) {
            if (t1[i] != t2[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] times(String s) {
        int[] times = new int[26];
        for (char a : s.toCharArray()) {
            times[a - 'a'] += 1;
        }
        return times;
    }


}










