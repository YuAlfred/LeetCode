package 程序员面试经典;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/25 10:12 下午
 * @description : 面试题 16.26. 计算器
 * @modified By  :
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculator-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_26_middle_计算器 {

    public static void main(String[] args) {
        calculate(" 3/2 ");
    }

    public static int calculate(String s) {
        s = s.trim();
        Deque<Integer> stack = new LinkedList<>();
        char sign = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == ' ') {
                continue;
            } else if (Character.isDigit(a)) {
                num = num * 10 + (a - '0');
            }
            if (!Character.isDigit(a) || i == s.length() - 1) {
                switch (sign) {
                    case '+': {
                        stack.push(num);
                        break;
                    }
                    case '-': {
                        stack.push(-num);
                        break;
                    }
                    case '*': {
                        stack.push(stack.poll() * num);
                        break;
                    }
                    case '/': {
                        stack.push(stack.poll() / num);
                        break;
                    }
                }
                sign = a;
                num = 0;
            }
        }
        stack.push(num);
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;

    }
}
