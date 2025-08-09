package 程序员面试经典;

import java.util.Stack;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/10 3:01 下午
 * @description : 面试题 03.04. 化栈为队
 * @modified By  :
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M3_4_easy_化栈为队 {

    class MyQueue {

        public Stack<Integer> s1;
        public Stack<Integer> s2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            s1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }


}
