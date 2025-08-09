package 每日打卡;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/2/23 10:08
 * @description : 1052. 爱生气的书店老板
 * @modified By  :
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1052_middle_爱生气的书店老板 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int maxSatisfy = 0;
        int satisfy = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfy += customers[i];
            }
        }
        int left = 0, right = 0;
        for (; right < X; right++) {
            if (grumpy[right] == 1) {
                satisfy += customers[right];
            }
        }
        maxSatisfy = satisfy;
        for (; right < n; right++, left++) {
            if (grumpy[right] == 1) {
                satisfy += customers[right];
            }
            if (grumpy[left] == 1) {
                satisfy -= customers[left];
            }
            maxSatisfy = Math.max(maxSatisfy, satisfy);
        }
        return maxSatisfy;
    }

}
