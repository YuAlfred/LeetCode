package 每日打卡;

import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 825. 适龄的朋友
 * @date: 2021/12/28 2:49 PM
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 * <p>
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 * <p>
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 * <p>
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 * <p>
 * 返回在该社交媒体网站上产生的好友请求总数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * 示例 2：
 * <p>
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * 示例 3：
 * <p>
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 *  
 * <p>
 * 提示：
 * <p>
 * n == ages.length
 * 1 <= n <= 2 * 104
 * 1 <= ages[i] <= 120
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M825_middle_适龄的朋友 {

    public static void main(String[] args) {
        M825_middle_适龄的朋友 m = new M825_middle_适龄的朋友();
        System.out.println(m.numFriendRequests(new int[]{108, 115, 5, 24, 82}));
    }

    public int numFriendRequests(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            cnt[age]++;
        }
        // 前缀和
        int[] preSum = new int[121];
        for (int i = 1; i < 121; i++) {
            preSum[i] = preSum[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int age = 15; age < 121; age++) {
            if (cnt[age] > 0) {
                ans += cnt[age] * (preSum[age] - preSum[(int) (age * 0.5) + 7] - 1);
            }
        }
        return ans;
    }


}
