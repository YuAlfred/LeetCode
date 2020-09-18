package 程序员面试经典;

import java.util.*;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 9:42 上午
 * @description : 面试题 03.03. 堆盘子
 * @modified By  :
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * <p>
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * 示例2:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stack-of-plates-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M3_3_middle_堆盘子 {

    public static void main(String[] args) {
        StackOfPlates s = new StackOfPlates(1);
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s.popAt(0));
        // System.out.println(s.popAt(0));
        // System.out.println(s.popAt(0));

        s.push(1);
        s.push(2);
        System.out.println(s.popAt(1));
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    static class StackOfPlates {

        public List<Deque<Integer>> stack;
        public int stackSize;
        public int cap;

        public StackOfPlates(int cap) {
            stack = new LinkedList<>();
            this.cap = cap;
            this.stackSize = 0;
        }

        public void push(int val) {
            if (cap <= 0) {
                return;
            }
            if (stack.isEmpty() || stack.get(stackSize - 1).size() == cap) {
                ArrayDeque<Integer> temp = new ArrayDeque<>(cap);
                stack.add(temp);
                stackSize++;
            }
            stack.get(stackSize - 1).push(val);
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            int res = stack.get(stackSize - 1).pop();
            if (stack.get(stackSize - 1).isEmpty()) {
                stack.remove(stackSize - 1);
                stackSize--;
            }
            return res;
        }

        public int popAt(int index) {
            if (index >= stackSize) {
                return -1;
            }
            int res = stack.get(index).pop();
            if (stack.get(index).isEmpty()) {
                stack.remove(index);
                stackSize--;
            }
            return res;
        }
    }


}
