package 面试笔试.农行2021_4_27;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/27 3:11 下午
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.getStr("A3B5c2");
    }


    public String getStr(String command) {

        StringBuilder sb = new StringBuilder();
        char a;
        int times = 0;
        for (int i = 1; i < command.length(); i+=2) {
            a = command.charAt(i - 1);
            times = command.charAt(i) - '0';
            for (int j = 0; j < times; j++) {
                sb.append(a);
            }
        }
        return sb.toString();
    }


}
