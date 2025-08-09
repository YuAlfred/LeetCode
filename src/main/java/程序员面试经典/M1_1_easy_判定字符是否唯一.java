package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/8 5:12 下午
 * @description : 判定字符是否唯一
 * @modified By  :
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1_1_easy_判定字符是否唯一 {

    public static void main(String[] args) {
        isUnique("aaa");
    }

    public static boolean isUnique(String astr) {
        boolean[] res = new boolean[26];
        for (char a : astr.toCharArray()) {
            if (res[a - 'a']) {
                return false;
            } else {
                res[a - 'a'] = true;
            }
        }
        return true;
    }

}








