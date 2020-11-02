package 程序员面试经典;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.19. 消失的两个数字
 * @date: 2020/10/30 3:40 下午
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 * <p>
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 * <p>
 * nums.length <= 30000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-two-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_19_hard_消失的两个数字 {

    public static void main(String[] args) {
        M17_19_hard_消失的两个数字 m = new M17_19_hard_消失的两个数字();
        m.missingTwo(new int[]{1, 2, 3, 4, 6, 7, 9, 10});
    }

    public int[] missingTwo(int[] nums) {
        int length = nums.length + 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int sumTwo = ((1 + length) * length) / 2 - sum;
        int split = sumTwo / 2;
        sum = 0;
        for (int i : nums) {
            if (i <= split) {
                sum += i;
            }
        }
        int one = ((1 + split) * split) / 2 - sum;
        return new int[]{one, sumTwo - one};

    }

}














