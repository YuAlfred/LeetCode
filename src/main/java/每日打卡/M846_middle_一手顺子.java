package 每日打卡;

import java.util.TreeMap;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 846. 一手顺子
 * @date: 2021/12/30 8:30 PM
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * <p>
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 *  
 * <p>
 * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M846_middle_一手顺子 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : hand) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        while (!treeMap.isEmpty()) {
            int first = treeMap.firstKey();
            int end = first + groupSize;
            while (first < end) {
                if (!treeMap.containsKey(first) || treeMap.get(first) == 0) {
                    return false;
                }
                treeMap.put(first, treeMap.get(first) - 1);
                if (treeMap.get(first) == 0) {
                    treeMap.remove(first);
                }
                first++;
            }
        }
        return true;
    }


}
