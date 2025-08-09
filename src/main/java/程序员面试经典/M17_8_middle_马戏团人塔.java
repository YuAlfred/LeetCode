package 程序员面试经典;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 4:50 下午
 * @description : 面试题 17.08. 马戏团人塔
 * @modified By  :
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 * <p>
 * 示例：
 * <p>
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * 提示：
 * <p>
 * height.length == weight.length <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circus-tower-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_8_middle_马戏团人塔 {


    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] peoples = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            peoples[i][0] = height[i];
            peoples[i][1] = weight[i];
        }
        Arrays.sort(peoples, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                //重点，高度相同体重降序排列，这样待会儿二分法求最长子序列就不会找到相同高度的结果
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int len = 0;
        int[] tail = new int[peoples.length];
        for (int i = 0; i < peoples.length; i++) {
            int j = 0, k = len;
            int m;
            while (j < k) {
                m = (j + k) / 2;
                if (tail[m] < peoples[i][1]) {
                    j = m + 1;
                } else {
                    k = m;
                }
            }
            tail[j] = peoples[i][1];
            if (len == k) {
                len++;
            }
        }
        return len;
    }


}
