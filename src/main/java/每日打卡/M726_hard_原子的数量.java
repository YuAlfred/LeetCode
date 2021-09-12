package 每日打卡;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 726. 原子的数量
 * @date: 2021/7/5 12:13 上午
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * <p>
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * <p>
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * <p>
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * <p>
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * <p>
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * 示例 2:
 * <p>
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * 示例 3:
 * <p>
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 * 注意:
 * <p>
 * 所有原子的第一个字母为大写，剩余字母都是小写。
 * formula的长度在[1, 1000]之间。
 * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M726_hard_原子的数量 {


    int index = 0;

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> ans = dfs(formula);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : ans.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue() == 1 ? "" : entry.getValue());
        }
        return sb.toString();
    }

    public TreeMap<String, Integer> dfs(String formula) {
        TreeMap<String, Integer> ans = new TreeMap<>();
        while (index < formula.length()) {
            char c = formula.charAt(index);
            if (c == '(') {
                index++;
                Map<String, Integer> tempAns = dfs(formula);
                tempAns.forEach((k, v) -> ans.put(k, ans.getOrDefault(k, 0) + v));
            } else if (c == ')') {
                index++;
                int num = readNum(formula);
                ans.replaceAll((s, v) -> v * num);
                return ans;
            } else {
                String name = readName(formula);
                int num = readNum(formula);
                int origin = ans.getOrDefault(name, 0);
                ans.put(name, num + origin);
            }
        }
        return ans;
    }

    public int readNum(String formula) {
        if (index >= formula.length()) {
            return 1;
        }
        int num = 0;
        char c = formula.charAt(index);
        while (c <= '9' && c >= '0') {
            num = num * 10 + (c - '0');
            index++;
            if (index >= formula.length()) {
                break;
            }
            c = formula.charAt(index);
        }
        return num == 0 ? 1 : num;
    }

    public String readName(String formula) {
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(index));
        index++;
        while (index < formula.length() && formula.charAt(index) <= 'z' && formula.charAt(index) >= 'a') {
            sb.append(formula.charAt(index));
            index++;
        }
        return sb.toString();
    }


}











