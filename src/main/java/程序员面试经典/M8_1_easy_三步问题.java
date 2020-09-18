package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 11:16 上午
 * @description : 面试题 08.01. 三步问题
 * @modified By  :
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * 提示:
 * <p>
 * n范围在[1, 1000000]之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_1_easy_三步问题 {


    public int waysToStep(int n) {
        int i = 0, j = 0, k = 1;
        for (int l = 1; l <= n; l++) {
            int sum = ((i + j)%1000000007 + k)%1000000007;
            i = j;
            j = k;
            k = sum;
        }
        return k;
    }

}
