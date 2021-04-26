package 每日打卡;

import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1011. 在 D 天内送达包裹的能力
 * @date: 2021/4/26 9:08 上午
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1011_middle_在D天内送达包裹的能力 {


    public int shipWithinDays(int[] weights, int D) {

        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = (left + right) / 2;
            int day = 1;
            int tempWeight = mid;
            for (int weight : weights) {
                if (tempWeight - weight < 0) {
                    day++;
                    tempWeight = mid;
                }
                tempWeight -= weight;
            }
            if (day > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
