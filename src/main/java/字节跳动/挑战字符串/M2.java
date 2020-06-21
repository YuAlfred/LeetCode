package 字节跳动.挑战字符串;

/**
 * @author : ty
 * @version : 最长公共前缀
 * @date : Created in 2020/6/7 16:18
 * @description : 1.0.0
 * @modified By  :
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class M2 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        //首先判断参数数组是否为空
        if (strs == null || strs.length == 0) {
            return "";
        }
        //然后数组中各个元素是否为空
        for (String s : strs) {
            if (s == null || s.length() == 0) {
                return "";
            }
        }

        int i = -1;
        boolean flag = true;


        while (flag) {
            i++;
            if (i >= strs[0].length()) {
                flag = false;
                break;
            }
            char a = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {

                if (i >= strs[j].length() || strs[j].charAt(i) != a) {
                    flag = false;
                    break;
                }
            }
        }

        return strs[0].substring(0, i);
    }
}
