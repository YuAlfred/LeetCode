package 剑指offer;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 752. 打开转盘锁
 * @date: 2021/6/25 8:39 下午
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M752_middle_打开转盘锁 {

    public static void main(String[] args) {
        M752_middle_打开转盘锁 m = new M752_middle_打开转盘锁();
        m.openLock(new String[]{}, "8888");
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadEndsSet = new HashSet<>();
        for (String deadend : deadends) {
            deadEndsSet.add(deadend);
        }
        if (deadEndsSet.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        Map<String, Integer> steps = new HashMap<>();
        Queue<String> list = new LinkedList<>();
        String startPoint = "0000";
        list.add(startPoint);
        steps.put(startPoint, 0);
        while (!list.isEmpty()) {
            int n = list.size();
            for (int i = 0; i < n; i++) {
                String num = list.poll();
                int curStep = steps.get(num);
                List<String> nextNums = get(num);
                for (String nextNum : nextNums) {
                    if (deadEndsSet.contains(nextNum) || steps.containsKey(nextNum)) {
                        continue;
                    }
                    int nextStep = curStep + 1;
                    if (nextNum.equals(target)) {
                        return nextStep;
                    }
                    steps.put(nextNum, nextStep);
                    list.add(nextNum);
                }
            }
        }
        return -1;
    }

    public char add(char a) {
        return a == '9' ? '0' : (char) (a + 1);
    }

    public char sub(char a) {
        return a == '0' ? '9' : (char) (a - 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = add(num);
            ret.add(new String(array));
            array[i] = sub(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }


}
