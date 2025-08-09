package 剑指offer;

import java.util.PriorityQueue;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/16 18:21
 * @description : 剑指 Offer 41. 数据流中的中位数
 * @modified By  :
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *  
 * <p>
 * 限制：
 * <p>
 * 最多会对 addNum、findMedia进行 50000 次调用。
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M41_hard_数据流中的中位数 {

    public static void main(String[] args) {
        M41_hard_数据流中的中位数 x = new M41_hard_数据流中的中位数();
        x.addNum(1);
        x.addNum(2);
        System.out.println(x.findMedian());
        System.out.println();
    }

    private PriorityQueue<Integer> small, large;

    /**
     * initialize your data structure here.
     */
    public M41_hard_数据流中的中位数() {
        small = new PriorityQueue<>((o1, o2) -> o2 - o1);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.size() == large.size()) {
            large.add(num);
            small.add(large.poll());
        } else {
            small.add(num);
            large.add(small.poll());
        }
    }

    public double findMedian() {
        return small.size() == large.size() ? (small.peek() + large.peek()) / 2.0 : small.peek();
    }
}




