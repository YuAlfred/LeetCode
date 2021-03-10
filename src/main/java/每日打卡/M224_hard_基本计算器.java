package 每日打卡;

import java.util.Stack;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/17 4:59 下午
 * @description : 224. 基本计算器
 * @modified By  :
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M224_hard_基本计算器 {

    public static void main(String[] args) {
        System.out.println(calculate("(1+(2*5/2)-4)+7"));
    }

    public static int calculate(String s) {
        s = s.trim();
        return calculate(new StringBuilder(s));
    }


    public static int calculate(StringBuilder s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        while (!(s.length() == 0)) {
            char a = s.charAt(0);
            s.deleteCharAt(0);
            if (isNum(a)) {
                num = num * 10 + (a - '0');
            }
            if (a == ' ') {
                continue;
            } else if (!isNum(a) || s.length() == 0) {
                if (a == '(') {
                    num = calculate(s);
                }
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
                        stack.push(stack.pop() * num);
                        break;
                    }
                    case '/': {
                        stack.push(stack.pop() / num);
                        break;
                    }
                }
                sign = a;
                num = 0;
                if (a == ')') {
                    break;
                }
            }
        }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }

    public static boolean isNum(char a) {
        return a <= '9' && a >= '0';
    }
}


class 基本计算器2 {

    public int calculate(String s) {
        return calc(s, 0)[0];
    }

    public int[] calc(String s, int index) {

        int flag = 1;
        Stack<Integer> stack = new Stack<>();
        int num = 0;

        int i = index;
        for (; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == ' ') {
                continue;
            } else if (a <= '9' && a >= '0') {
                num = num * 10 + (a - '0');
            } else if (a == '+') {
                stack.push(num * flag);
                num = 0;
                flag = 1;
            } else if (a == '-') {
                stack.push(num * flag);
                num = 0;
                flag = -1;
            } else if (a == '(') {
                int[] res = calc(s, i + 1);
                num = res[0];
                i = res[1];
            } else if (a == ')') {
                stack.push(num * flag);
                int sum = 0;
                for (int j : stack) {
                    sum += j;
                }
                int[] res = new int[2];
                res[0] = sum;
                res[1] = i;
                return res;
            }
        }
        stack.push(num * flag);
        int sum = 0;
        for (int j : stack) {
            sum += j;
        }
        int[] res = new int[2];
        res[0] = sum;
        res[1] = i;
        return res;
    }
}






