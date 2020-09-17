package 面试笔试.好未来9_11;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/11 6:00 下午
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Test25 {

    private static Stack<Character> stackOPR = new Stack<>(); //操作符栈
    private static Stack<Integer> stackOPN = new Stack<>();//操作数栈

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();

        for (char c : s.toCharArray()) {
            if (isOPN(c)) { //判断是否是操作数
                //是 则入操作数栈 ，读入下一个
                stackOPN.push(c - 48); //asc码 '0'转为int是48  A是65 a是97
            } else {
                switch (isPrior(c)) {
                    case '>':  //优先级比栈顶元素大 ，则入栈,并接收下一个字符
                        stackOPR.push(c);
                        break;
                    case '='://优先级和栈顶元素相同
                        stackOPR.pop(); //脱去括号
                        break;
                    case '<': //优先级比栈顶元素小，则操作数出栈，操作符出栈，运算之后入栈。即意思是优先级高的先运算
                        int b = stackOPN.pop();//顺序靠后的操作数
                        int a = stackOPN.pop();//顺序靠前的操作数
                        stackOPN.push(Option(a, b, stackOPR.pop()));
                        break;
                }
            }
        }
        System.out.println("计算结果为:" + stackOPN.pop());
    }

    //返回和栈顶元素优先级的比较结果，> 表示优先级大于栈顶元素 <  表示优先级小于栈顶元素 =表示优先级相等
    static char isPrior(Character c) {
        char c2 = stackOPR.peek();
        if (c == '+' || c == '-') { //c为后进入的操作符，c2为之前进入的操作符
            //如果同为+ - 则c2的优先级大于c  同理 * /就更不用说了
            if (c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/') {  //所以和栈顶元素相比 优先级要小
                return '<';
            }
            if (c2 == '(') {
                return '>';
            }
            if (c2 == ')') {
                return '<';
            }
            if (c2 == '#') {
                return '>'; //#是定义为预算结束的标志符 比所有的操作符优先级都小
            }
        }
        if (c == '*' || c == '/') {
            if (c2 == '+' || c2 == '-') {
                return '>';
            }

            if (c2 == '*' || c2 == '/') {
                return '<';
            }
            if (c2 == '(') {
                return '>';
            }
            if (c2 == ')') {
                return '<';
            }
            if (c2 == '#') {
                return '>';
            }
        }


        if (c == '(') {
            return '>';
        }
        if (c == ')') {
            if (c2 != '(') {
                return '<';
            } else {
                return '=';
            }
        }

        if (c == '#') {
            if (c2 != '#') {
                return '<';
            } else {
                return '=';
            }
        }
        return 0;
    }


    static int Option(int a, int b, Character c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    static boolean isOPN(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '#') {
            return false;
        } else {
            return true;
        }
    }
}

