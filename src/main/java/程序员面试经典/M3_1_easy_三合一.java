package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/10 3:40 下午
 * @description : 面试题 03.01. 三合一
 * @modified By  :三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M3_1_easy_三合一 {


    class TripleInOne {
        public int[] stacks;
        public int[] stackPoint;
        public int stackSize;

        public TripleInOne(int stackSize) {
            stacks = new int[stackSize * 3];
            stackPoint = new int[3];
            stackPoint[0] = -1;
            stackPoint[1] = -1;
            stackPoint[2] = -1;
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            if (stackPoint[stackNum] < stackSize - 1) {
                stackPoint[stackNum]++;
                stacks[stackPoint[stackNum]+ stackSize * stackNum] = value;
            }
        }

        public int pop(int stackNum) {
            int res = -1;
            if (stackPoint[stackNum] >= 0) {
                res = stacks[stackPoint[stackNum] + stackSize * stackNum];
                stackPoint[stackNum]--;
            }
            return res;
        }

        public int peek(int stackNum) {
            int res = -1;
            if (stackPoint[stackNum] >= 0) {
                res = stacks[stackPoint[stackNum] + stackSize * stackNum];
            }
            return res;
        }

        public boolean isEmpty(int stackNum) {
            return stackPoint[stackNum] < 0;
        }
    }


}
