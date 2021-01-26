package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1128. 等价多米诺骨牌对的数量
 * @date: 2021/1/26 8:45 上午
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1128_easy_等价多米诺骨牌对的数量 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] val = new int[100];
        int res = 0;
        for (int[] domino : dominoes) {
            int x = Math.max(domino[0], domino[1]);
            int y = Math.min(domino[0], domino[1]);
            int p = x * 10 + y;
            res += val[p];
            val[p]++;
        }
        return res;
    }


}
