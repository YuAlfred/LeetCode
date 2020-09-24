package 程序员面试经典;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/23 11:09 下午
 * @description : 面试题 16.18. 模式匹配
 * @modified By  :
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 * <p>
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 * <p>
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 * <p>
 * 1 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_18_middle_模式匹配 {

    public static void main(String[] args) {
        System.out.println(patternMatching("ab", ""));
    }

    public static boolean patternMatching(String pattern, String value) {
        char[] cPattern = pattern.toCharArray();
        char[] cValue = value.toCharArray();
        int numA = 0, numB = 0;
        //都换成a开头
        boolean change = cPattern[0] == 'b';
        for (int i = 0; i < cPattern.length; i++) {
            if (cPattern[i] == 'a') {
                if (change) {
                    cPattern[i] = 'b';
                    numB++;
                } else {
                    numA++;
                }
            } else {
                if (change) {
                    cPattern[i] = 'a';
                    numA++;
                } else {
                    numB++;
                }
            }
        }
        if (value.isEmpty() && (pattern.isEmpty() || (numA == 1 && numB == 0))) {
            return true;
        } else if (value.isEmpty()) {
            return false;
        }
        int aLength = 0, bLength = 1;
        for (; aLength <= cValue.length / numA; aLength++) {
            if (numB == 0) {
                bLength = 0;
            } else if ((cValue.length - aLength * numA) % numB != 0) {
                continue;
            } else {
                bLength = (cValue.length - aLength * numA) / numB;
            }
            char[] a = Arrays.copyOf(cValue, aLength);
            char[] b = null;
            int i = 0, j = 0;
            while (i < cPattern.length && j < cValue.length) {
                if (cPattern[i] == 'a') {
                    if (j + aLength > cValue.length) {
                        break;
                    }
                    if (!Arrays.equals(a, Arrays.copyOfRange(cValue, j, j + aLength))) {
                        break;
                    }
                    j += aLength;
                } else {
                    if (j + bLength > cValue.length) {
                        break;
                    }
                    if (b == null) {
                        b = Arrays.copyOfRange(cValue, j, j + bLength);
                        j += bLength;
                        i++;
                        continue;
                    }
                    if (!Arrays.equals(b, Arrays.copyOfRange(cValue, j, j + bLength))) {
                        break;
                    }
                    j += bLength;
                }
                i++;
            }
            if (Arrays.equals(a, b)) {
                continue;
            }
            if (i == cPattern.length && j == cValue.length || (j == cValue.length && (aLength == 0 || bLength == 0))) {
                return true;
            }
        }
        return false;

    }
}












