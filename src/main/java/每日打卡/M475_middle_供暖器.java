package 每日打卡;

import java.util.Arrays;

/**
 * @author : Alfred.T
 * @version : 1.0.0
 * @date : Created in 2021/12/20 1:10
 * @description : 475. 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 * <p>
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 示例 3：
 * <p>
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M475_middle_供暖器 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        M475_middle_供暖器 m = new M475_middle_供暖器();
        System.out.println(m.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int minArea = 0;
        int houseI = 0, heaterI = 0;
        // 遍历每个房子
        while (houseI < houses.length) {
            // 如果当前采暖器在它后面就看后一个采暖器
            while (houses[houseI] > heaters[heaterI] && heaterI < heaters.length - 1) {
                heaterI++;
            }
            int curMinArea = Math.abs(heaters[heaterI] - houses[houseI]);
            if (heaterI > 0) {
                curMinArea = Math.min(curMinArea, Math.abs(heaters[heaterI - 1] - houses[houseI]));
            }
            minArea = Math.max(minArea, curMinArea);
            houseI++;
        }
        return minArea;
    }


}
