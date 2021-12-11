package 每日打卡;

/**
 * @author : Alfred.T
 * @version : 1.0.0
 * @date : Created in 2021/12/5 12:04
 * @description : 372. 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 * <p>
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 * <p>
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M372_middle_超级次方 {

    int mod = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i : b) {
            ans = pow(ans, 10) * pow(a, i) % mod;
        }
        return ans;
    }

    public int pow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (int) (((long) res * a) % mod);
            }
            a = (int) ((long) a * a % mod) % mod;
            b /= 2;
        }
        return res;
    }


}
