package 每日打卡;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 480. 滑动窗口中位数
 * @date: 2021/2/3 9:16 上午
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M480_hard_滑动窗口中位数 {

    public static void main(String[] args) {
        M480_hard_滑动窗口中位数 m = new M480_hard_滑动窗口中位数();
        m.medianSlidingWindow(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648,
            2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 3);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //init
        for (int i = 0; i < k && i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        int mid = k / 2;
        while (mid > 0) {
            minHeap.add(maxHeap.poll());
            mid--;
        }

        double[] res = new double[nums.length - k + 1];
        res[0] = (k & 1) == 0 ? maxHeap.peek() / 2.0 + minHeap.peek() / 2.0 : maxHeap.peek();
        for (int i = 0, j = k; j < nums.length; j++, i++) {
            if (maxHeap.contains(nums[i])) {
                maxHeap.remove(nums[i]);
                maxHeap.add(nums[j]);
            } else {
                minHeap.remove(nums[i]);
                minHeap.add(nums[j]);
            }
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
            res[i + 1] = (k & 1) == 0 ? maxHeap.peek() / 2.0 + minHeap.peek() / 2.0 : maxHeap.peek();
        }
        return res;
    }

}
