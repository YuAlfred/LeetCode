//package 每日打卡;
//
//import java.util.List;
//
///**
// * @author : Alfred
// * @version : 1.0.0
// * @date : Created in 2021/10/16 15:48
// * @description : 282. 给表达式添加运算符
// * 给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
// * <p>
// *  
// * <p>
// * 示例 1:
// * <p>
// * 输入: num = "123", target = 6
// * 输出: ["1+2+3", "1*2*3"]
// * 示例 2:
// * <p>
// * 输入: num = "232", target = 8
// * 输出: ["2*3+2", "2+3*2"]
// * 示例 3:
// * <p>
// * 输入: num = "105", target = 5
// * 输出: ["1*0+5","10-5"]
// * 示例 4:
// * <p>
// * 输入: num = "00", target = 0
// * 输出: ["0+0", "0-0", "0*0"]
// * 示例 5:
// * <p>
// * 输入: num = "3456237490", target = 9191
// * 输出: []
// *  
// * <p>
// * 提示：
// * <p>
// * 1 <= num.length <= 10
// * num 仅含数字
// * -231 <= target <= 231 - 1
// * <p>
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/expression-add-operators
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//public class M282_hard_给表达式添加运算符 {
//
//    public List<String> addOperators(String num, int target) {
//
//    }
//
//    public void dfs()
//
//    public int calc(List<String> list) {
//        // 先算*
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals("*")) {
//                int ans = Integer.parseInt(list.get(i - 1)) * Integer.parseInt(list.get(i + 1));
//                list.remove(i + 1);
//                list.remove(i);
//                list.remove(i - 1);
//                i--;
//                list.add(i, String.valueOf(ans));
//            }
//        }
//        // 再算 + -
//        for (int i = 0; i < list.size(); i++) {
//
//            if (list.get(i).equals("+")) {
//                int ans = Integer.parseInt(list.get(i - 1)) + Integer.parseInt(list.get(i + 1));
//                list.remove(i + 1);
//                list.remove(i);
//                list.remove(i - 1);
//                i--;
//                list.add(i, String.valueOf(ans));
//            } else if (list.get(i).equals("-")) {
//                int ans = Integer.parseInt(list.get(i - 1)) - Integer.parseInt(list.get(i + 1));
//                list.remove(i + 1);
//                list.remove(i);
//                list.remove(i - 1);
//                i--;
//                list.add(i, String.valueOf(ans));
//            }
//        }
//        return Integer.valueOf(list.get(0));
//    }
//
//}
