package 剑指offer;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/3 10:02 下午
 * @description : 剑指 Offer 60. n个骰子的点数
 * @modified By  :
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 *  
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 11
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M60_easy_n个骰子的点数 {


    public double[] twoSum(int n) {

        double[][] times = new double[n + 1][n * 6 + 1];
        for (int i = 1; i < 7; i++) {
            times[1][i] = 1 / 6.0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= (i-1) * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    times[i][j + k] += times[i - 1][j] / 6.0;
                }
            }
        }
        int i = 1;
        while (times[n][i] == 0) {
            i++;
        }
        return Arrays.copyOfRange(times[n], i,times[n].length );

    }


}







