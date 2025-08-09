package 每日打卡;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 341. 扁平化嵌套列表迭代器
 * @date: 2021/3/23 10:32 上午
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M341_middle_扁平化嵌套列表迭代器 {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        Stack<Iterator<NestedInteger>> stack;
        int next = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.stack = new Stack<>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return next;
        }

        @Override
        public boolean hasNext() {
            while (!stack.empty() && !stack.peek().hasNext()) {
                stack.pop();
            }
            if (stack.empty()) {
                return false;
            }
            Iterator<NestedInteger> it = stack.peek();
            NestedInteger nestedInteger = it.next();
            if (!nestedInteger.isInteger()) {
                stack.push(nestedInteger.getList().iterator());
                return hasNext();
            } else {
                next = nestedInteger.getInteger();
                return true;
            }
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


}
