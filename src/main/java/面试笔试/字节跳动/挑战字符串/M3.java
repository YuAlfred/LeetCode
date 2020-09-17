package 面试笔试.字节跳动.挑战字符串;

/**
 * @author : ty
 * @version : 字符串的排列
 * @date : Created in 2020/6/7 16:42
 * @description : 1.0.0
 * @modified By  :
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * a ==97(ascii)
 */
public class M3 {

    public static void main(String[] args) {
        M3 m3 = new M3();

        System.out.println(m3.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        //存放26个字母的个数
        int[] buff = new int[26];
        for (char a : s1.toCharArray()) {
            buff[a - 97]++;
        }
        //当前匹配的长度
        int length = 0;

        int[] temp = new int[26];
        int i = 0, j = -1;

        while (i < s2.length() && j + 1 < s2.length()) {
            int compared = compare(temp, buff);

            if (compared == 0) {
                return true;
            } else if (compared == -1) {
                j++;
                temp[s2.charAt(j) - 97]++;
            } else {
                temp[s2.charAt(i) - 97]--;
                i++;
            }
        }
        return compare(temp, buff) == 0;
    }


    public int compare(int[] temp, int[] buff) {
        boolean over = false;
        boolean fit = true;

        for (int i = 0; i < 26; i++) {
            if (temp[i] > buff[i]) {
                over = true;
                break;
            } else if (temp[i] < buff[i]) {
                fit = false;
            }
        }

        if (over) {
            return 1;
        }
        if (fit) {
            return 0;
        }
        return -1;
    }
}
