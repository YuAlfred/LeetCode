package 面试笔试.华为2021_4_14;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/14 7:35 下午
 */
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        StringBuilder input = new StringBuilder(in.next());
        // END 输入
        // 递归调用
        System.out.println(reverse(input));
    }


    /**
     * 递归反转，负责反转一个括号内的内容
     *
     * @param in 输入的字符串
     * @return 括号内的内容（正序）
     */
    public static StringBuilder reverse(StringBuilder in) {
        // 此括号内的内容（正序）
        StringBuilder sb = new StringBuilder();
        while (in.length() > 0) {
            //拿出原始数据的第一个字符，然后在原始数据中删除它
            char c = in.charAt(0);
            in.deleteCharAt(0);
            if (c == ')') {
                // 如果是反括号则结束此次反转
                break;
            } else if (c == '(') {
                // 如果是正括号则递归调用，拿到括号内的内容后做反转操作
                sb.append(reverse(in).reverse());
            } else {
                // 为普通字符则直接添加到此括号内容中
                sb.append(c);
            }
        }
        // 返回结果（正序）
        return sb;
    }
}
