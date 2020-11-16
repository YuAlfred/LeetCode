package 每日打卡;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 406. 根据身高重建队列
 * @date: 2020/11/16 4:34 下午
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M406_middle_根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> res = new LinkedList<>();
        for (int[] one : people) {
            res.add(one[1], one);
        }
        return res.toArray(new int[people.length][2]);
    }
}


















