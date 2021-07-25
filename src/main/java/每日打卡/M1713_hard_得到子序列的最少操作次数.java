package 每日打卡;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1713. 得到子序列的最少操作次数
 * @date: 2021/7/26 12:51 上午
 * 给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
 * <p>
 * 每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。
 * <p>
 * 请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
 * <p>
 * 一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = [5,1,3], arr = [9,4,2,3,4]
 * 输出：2
 * 解释：你可以添加 5 和 1 ，使得 arr 变为 [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
 * 示例 2：
 * <p>
 * 输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length, arr.length <= 105
 * 1 <= target[i], arr[i] <= 109
 * target 不包含任何重复元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1713_hard_得到子序列的最少操作次数 {

    public static void main(String[] args) {
        M1713_hard_得到子序列的最少操作次数 m = new M1713_hard_得到子序列的最少操作次数();
        m.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1});
    }


    public int minOperations(int[] target, int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        int c = 0;
        for (int j = 0; j < target.length; j++) {
            map.put(target[j], c);
            target[j] = c;
            c++;
        }
        List<Integer> arrList = new LinkedList<>();
        for (int a : arr) {
            if (map.containsKey(a)) {
                arrList.add(map.get(a));
            }
        }
        arr = arrList.stream().mapToInt(Integer::intValue).toArray();

        // 找最长递增子序列
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int point = Collections.binarySearch(list, num);
                if (point < 0) {
                    list.set(-point-1, num);
                }
            }
        }
        return target.length - list.size();

    }

}
