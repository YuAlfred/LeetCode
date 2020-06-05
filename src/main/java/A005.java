/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/9/3 11:37
 * @description : 5. 最长回文子串
 * @modified By  :
 */
public class A005 {

    public static void main(String[] args) {
        A005 a = new A005();
        String res = a.longestPalindrome("cbbd");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        char[] codedString = addCode(s);
        int[] p = new int[codedString.length];
        int R = -1;
        int C = -1;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < codedString.length; i++) {
            if (i >= R) {
                p[i] = 1;
            } else {
                p[i] = Integer.min(p[2 * C - i], R - i);
            }
            while (i + p[i] < codedString.length && i - p[i] >= 0 && codedString[i + p[i]] == codedString[i - p[i]]) {
                p[i]++;
            }
            if (p[i] > maxLength) {
                maxLength = p[i];
                C = i;
                R = i + p[i];
            }
//            System.out.println(p[i]);
        }
        return String.copyValueOf(codedString, 2 * C - R + 1, 2 * (R - C) - 1).replaceAll("#", "");
    }

    /**
     * 为每个字符前后加上特殊字符#
     *
     * @param s 间隔前字符串
     * @return 间隔后字符串
     */
    public char[] addCode(String s) {
        StringBuffer sb = new StringBuffer();
//        sb.append("$");
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }
}
