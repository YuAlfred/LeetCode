package 程序员面试经典;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 3:45 下午
 * @description : 面试题 08.13. 堆箱子
 * @modified By  :
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 * <p>
 * 输入使用数组[wi, di, hi]表示每个箱子。
 * <p>
 * 示例1:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 * 示例2:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * 提示:
 * <p>
 * 箱子的数目不大于3000个。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pile-box-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_13_hard_堆箱子 {


    public int pileBox(int[][] box) {
        //todo
        int[] maxHeight = new int[box.length];
        maxHeight[0] = box[0][2];
        int max = 0;
        Arrays.sort(box, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    maxHeight[i] = Math.max(maxHeight[i], maxHeight[j] + box[i][2]);
                    if (maxHeight[i] > max) {
                        max = maxHeight[i];
                    }
                }
            }
        }
        return max;
    }


}












