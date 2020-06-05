import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/4/9 7:45 下午
 * @description : 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @modified By  :
 */
public class MS22 {

    public static void main(String[] args) {
        MS22 m = new MS22();
        m.recursion("", 3, 0);
        for (String l : m.list) {
            System.out.println(l);
        }

    }

    public List<String> list = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        recursion("", n, 0);
        return list;
    }

    public void recursion(String pre, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(pre);
        }
        if (right != 0) {
            recursion(pre + ")", left, right - 1);
        }
        if (left != 0) {
            recursion(pre + "(", left - 1, right + 1);
        }
    }
}
