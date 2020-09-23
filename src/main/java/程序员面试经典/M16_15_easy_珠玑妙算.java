package 程序员面试经典;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/23 11:22 上午
 * @description : 面试题 16.15. 珠玑妙算
 * @modified By  :
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * <p>
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * <p>
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * <p>
 * 示例：
 * <p>
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * 提示：
 * <p>
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/master-mind-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_15_easy_珠玑妙算 {
    public int[] masterMind(String solution, String guess) {
        int right = 0;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                right++;
            }
        }
        Map<Character, Integer> m1 = new HashMap();
        Map<Character, Integer> m2 = new HashMap();
        for (int i = 0; i < 4; i++) {
            m1.put(solution.charAt(i),m1.getOrDefault(solution.charAt(i),0)+1);
            m2.put(guess.charAt(i),m2.getOrDefault(guess.charAt(i),0)+1);
        }
        count+=Math.min(m1.getOrDefault('R',0),m2.getOrDefault('R',0));
        count+=Math.min(m1.getOrDefault('Y',0),m2.getOrDefault('Y',0));
        count+=Math.min(m1.getOrDefault('G',0),m2.getOrDefault('G',0));
        count+=Math.min(m1.getOrDefault('B',0),m2.getOrDefault('B',0));
        return new int[]{right,count-right};
    }
}











