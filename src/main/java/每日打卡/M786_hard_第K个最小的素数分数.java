package 每日打卡;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 786. 第 K 个最小的素数分数
 * @date: 2021/11/29 4:39
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * <p>
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * <p>
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * 示例 2：
 * <p>
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M786_hard_第K个最小的素数分数 {


    public static void main(String[] args) {
        M786_hard_第K个最小的素数分数 m = new M786_hard_第K个最小的素数分数();
        System.out.println(m.kthSmallestPrimeFraction(new int[]{1, 7, 23, 29, 47}, 8)[0]);
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> (arr[o1.i] * arr[o2.j]) - (arr[o2.i] * arr[o1.j]));
        Node root = new Node(0, arr.length - 1);
        priorityQueue.add(root);
        while (true) {
            Node node = priorityQueue.poll();
            System.out.println(arr[node.i] + " " + arr[node.j]);
            if (node.i + 1 < node.j) {
                priorityQueue.add(new Node(node.i + 1, node.j));
            }
            if (node.i < node.j - 1) {
                priorityQueue.add(new Node(node.i, node.j - 1));
            }
            k--;
            if (k == 0) {
                return new int[]{arr[node.i], arr[node.j]};
            }
        }
    }

    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        int n = arr.length;
        List<int[]> frac = new ArrayList<int[]>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                frac.add(new int[]{arr[i], arr[j]});
            }
        }
        Collections.sort(frac, (x, y) -> x[0] * y[1] - y[0] * x[1]);
        return frac.get(k - 1);
    }

    class Node {

        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
