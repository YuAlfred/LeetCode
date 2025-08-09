package 面试笔试.字节2021_10_17;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/10/17 7:07 下午
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();

        Deque<Integer> minStack = new LinkedList<>();
        Deque<Integer> maxStack = new LinkedList<>();
        minStack.push(nums[0]);
        maxStack.push(nums[0]);
        int l = 0, r = 1;
        int ans = 0;
        while (l <= r && l < n) {
            // 右指针右移
            while (r < n && (maxStack.getLast() - minStack.getLast()) < k) {
                while (!minStack.isEmpty() && minStack.getFirst() > nums[r]) {
                    minStack.removeFirst();
                }
                minStack.addFirst(nums[r]);
                while (!maxStack.isEmpty() && maxStack.getFirst() < nums[r]) {
                    maxStack.removeFirst();
                }
                maxStack.addFirst(nums[r]);
                r++;
            }
            r--;
            // 加
            ans += (r - l);
            // 左移一次
            if (!minStack.isEmpty() && minStack.getLast() == nums[l]) {
                minStack.removeLast();
            }
            if (!maxStack.isEmpty() && maxStack.getLast() == nums[l]) {
                maxStack.removeLast();
            }
            l++;
        }
        System.out.println(ans);
    }

}
