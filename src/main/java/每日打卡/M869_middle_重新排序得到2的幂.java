package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 869. 重新排序得到 2 的幂
 * @date: 2021/10/28 9:16 下午
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：10
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：16
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：24
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：46
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M869_middle_重新排序得到2的幂 {

    public static void main(String[] args) {
        M869_middle_重新排序得到2的幂 m = new M869_middle_重新排序得到2的幂();
        System.out.println(m.reorderedPowerOf2(153454323));
    }

    public boolean reorderedPowerOf2(int n) {
        int a = 1;
        int min = n / 10;
        while (a < min) {
            a <<= 1;
        }
        while (a < Math.min((long) n * 10, Integer.MAX_VALUE)) {
            if (equal(a, n)) {
                return true;
            }
            if (a * (long) 2 > Integer.MAX_VALUE) {
                return false;
            }
            a <<= 1;
        }
        return false;
    }

    public boolean equal(int n1, int n2) {
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];
        while (n1 > 0) {
            nums1[n1 % 10]++;
            n1 /= 10;
        }
        while (n2 > 0) {
            nums2[n2 % 10]++;
            n2 /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }


}
