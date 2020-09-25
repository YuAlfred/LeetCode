package 程序员面试经典;

import java.util.PriorityQueue;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/25 10:24 上午
 * @description : 面试题 17.14. 最小K个数
 * @modified By  :
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_14_middle_最小K个数 {

    public int[] smallestK(int[] arr, int k) {
        if (k==0){
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size()<k){
                queue.add(arr[i]);
            }else {
                if (queue.peek()>arr[i]){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();

    }
}
















