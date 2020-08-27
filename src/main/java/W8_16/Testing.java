package W8_16;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */

import java.util.*;

public class Testing {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.next();
        in.close();

        String weight = input.substring(1, input.length() / 2 - 1);
        String[] weights = weight.split(",");
        String height = input.substring(input.length() / 2 + 2, input.length() - 1);
        String[] sHeights = height.split(",");
        List<Integer> list = new LinkedList<>();

        for (int i = 0, j = 0; i < weights.length && j < weights.length; ) {
            Integer temp = Integer.parseInt(weights[i]);
            if (temp < 0 || Integer.parseInt(sHeights[j]) < 0) {
                System.out.println(0);
                return;
            }
            if (temp == 1) {
                list.add(Integer.parseInt(sHeights[j]));
                i++;
                j++;
            } else if (temp > 1) {
                list.add(Integer.parseInt(sHeights[j]));
                temp--;
                weights[i] = String.valueOf(temp);
            } else {
                i++;
                j++;
            }
        }
        Integer[] heights = list.toArray(new Integer[list.size()]);

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        System.out.println(ans);
    }
}