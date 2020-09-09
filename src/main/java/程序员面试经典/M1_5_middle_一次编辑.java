package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/9 10:08 上午
 * @description : 面试题 01.05. 一次编辑
 * @modified By  :
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1_5_middle_一次编辑 {

    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        if (Math.abs(first.length()-second.length())>1){
            return false;
        }
        if (first.length() > second.length() && first.substring(1).equals(second)) {
            return true;
        } else if (first.length() < second.length() && first.equals(second.substring(1))) {
            return true;
        } else if (first.length() == second.length() && first.substring(1).equals(second.substring(1))) {
            return true;
        }
        if (first.charAt(0) == second.charAt(0)) {
            return oneEditAway(first.substring(1), second.substring(1));
        }
        return false;
    }


}













