package 每日打卡;

import java.util.Stack;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 227. 基本计算器 II
 * @date: 2021/3/11 10:30 上午
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
public class M227_middle_基本计算器II {

    public static void main(String[] args) {
        M227_middle_基本计算器II m = new M227_middle_基本计算器II();
        System.out.println(m.calculate(" 3/2 "));
    }


    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char flag = '+';

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a <= '9' && a >= '0') {
                num = num * 10 + (a - '0');
            }

            if (a == '+' || a == '-' || a == '*' || a == '/' || i == s.length() - 1) {
                int temp = num;
                switch (flag) {
                    case '+':
                        stack.push(temp);
                        break;
                    case '-':
                        stack.push(-temp);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                flag = a;
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
