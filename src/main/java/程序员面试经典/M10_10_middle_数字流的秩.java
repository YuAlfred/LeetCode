package 程序员面试经典;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 10.10. 数字流的秩
 * @date: 2020/10/14 5:27 下午
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
 * <p>
 * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
 * <p>
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例:
 * <p>
 * 输入:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * 输出:
 * [null,0,null,1]
 * 提示：
 * <p>
 * x <= 50000
 * track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-from-stream-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M10_10_middle_数字流的秩 {

    public static void main(String[] args) {
        StreamRank m = new StreamRank();
        m.getRankOfNumber(1);
        m.track(0);
        m.getRankOfNumber(0);
    }

    static class StreamRank {

        List<Integer> arrays;

        public StreamRank() {
            arrays = new LinkedList<>();
        }

        public void track(int x) {
            int index = Collections.binarySearch(arrays, x);
            if (index < 0) {
                index = -index - 1;
            }
            arrays.add(index, x);
        }

        public int getRankOfNumber(int x) {
            int index = Collections.binarySearch(arrays, x);
            if (index < 0) {
                index = -index - 1;
            }
            while (index < arrays.size() && arrays.get(index) <= x) {
                index++;
            }
            return index;
        }
    }

}








