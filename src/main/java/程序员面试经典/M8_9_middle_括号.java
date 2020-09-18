package 程序员面试经典;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 2:41 下午
 * @description : 面试题 08.09. 括号
 * @modified By  :
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_9_middle_括号 {

    public static void main(String[] args) {
        M8_9_middle_括号 m = new M8_9_middle_括号();
        m.generateParenthesis(3);
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        recur(res,path,n,0);
        return res;
    }

    public void recur(List<String> res, StringBuilder path, int n, int m) {
        if (n <= 0 && m <= 0) {
            res.add(new String(path));
        }
        if (n != 0) {
            path.append("(");
            recur(res, path, n - 1, m + 1);
            path.deleteCharAt(path.length() - 1);
        }
        if (m != 0) {
            path.append(")");
            recur(res, path, n, m - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


}
