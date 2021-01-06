package 每日打卡;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 399. 除法求值
 * @date: 2021/1/6 1:59 下午
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * <p>
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * <p>
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 * <p>
 *  
 * <p>
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 * <p>
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 * <p>
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M399_middle_除法求值 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!map.containsKey(a)) {
                map.put(a, count++);
            }
            if (!map.containsKey(b)) {
                map.put(b, count++);
            }
        }
        double[][] graph = new double[count][count];
        //初始化邻接表
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            graph[map.get(a)][map.get(b)] = values[i];
            graph[map.get(a)][map.get(a)] = 1;
            graph[map.get(b)][map.get(b)] = 1;
            graph[map.get(b)][map.get(a)] = 1 / values[i];
        }
        //Floyd算法
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    if (graph[j][k] == 0 && graph[j][i] != 0 && graph[i][k] != 0) {
                        graph[j][k] = graph[j][i] * graph[i][k];
                    }
                }
            }
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            if (!map.containsKey(a) || !map.containsKey(b) || graph[map.get(a)][map.get(b)] == 0) {
                res[i] = -1.0;
            } else {
                res[i] = graph[map.get(a)][map.get(b)];
            }
        }
        return res;
    }


}