package 每日打卡;

/**
 * @author : Alfred.T
 * @version : 1.0.0
 * @date : Created in 2022/1/2 1:20
 * @description : 390. 消除游戏
 * 给定一个从1 到 n 排序的整数列表。
 * 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 * 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 * 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 返回长度为 n 的列表中，最后剩下的数字。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * 输出:
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/elimination-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M390_middle_消除游戏 {

    public static void main(String[] args) {
        M390_middle_消除游戏 m = new M390_middle_消除游戏();
        m.lastRemaining(9);
    }

    public int lastRemaining(int n) {
        int start = 1, end = n;
        // 每项差
        int diff = 1;
        while (start != end) {
            // 先左往右
            // 算项数
            int count = (end - start) / diff + 1;
            start += diff;
            // 奇数项
            if ((count & 1) == 1) {
                end -= diff;
            }
            diff *= 2;
            if (start == end) {
                break;
            }
            // 从右到左
            count = (end - start) / diff + 1;
            end -= diff;
            if ((count & 1) == 1) {
                start += diff;
            }
            diff *= 2;
        }
        return start;
    }


}
