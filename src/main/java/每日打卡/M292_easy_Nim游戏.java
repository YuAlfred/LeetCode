package 每日打卡;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/9/18 23:05
 * @description :
 * 292. Nim 游戏
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * <p>
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合，你作为先手。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：false
 * 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：n = 2
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nim-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M292_easy_Nim游戏 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }


}
