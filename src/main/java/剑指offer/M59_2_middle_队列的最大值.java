package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/3 9:48 下午
 * @description : 剑指 Offer 59 - II. 队列的最大值
 * @modified By  :
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M59_2_middle_队列的最大值 {

    public Queue<Integer> queue;
    public Deque<Integer> max;


    public M59_2_middle_队列的最大值() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) {
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int res = queue.poll();
        if (max.peekFirst() == res) {
            max.pollFirst();
        }
        return res;
    }


}











