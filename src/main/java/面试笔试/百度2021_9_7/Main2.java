package 面试笔试.百度2021_9_7;

import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/7 7:31 下午
 */
public class Main2 {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] nums = new String[t];
        for (int i = 0; i < t; i++) {
            nums[i] = in.next();
        }
        in.close();

        // 计算每个数字并输出
        for (String num : nums) {
            StringBuilder sb = new StringBuilder();
            dfs(sb, num, 0);
            System.out.println(sb);
        }

    }

    // 返回是不是要借一位
    public static boolean dfs(StringBuilder sb, String num, int index) {
        if (index >= num.length()) {
            return false;
        }
        char c = num.charAt(index);
        int i = c - '0';
        // 如果有一位大于三，那至此以后全填三
        if (i > 3) {
            while (index < num.length()) {
                sb.append("3");
                index++;
            }
            return false;
        }

        // 否则就先看后续
        boolean needBorrow = dfs(sb, num, index + 1);
        if (needBorrow) {
            sb.delete(0,sb.length());
            for (int j = index + 1; j < num.length(); j++) {
                sb.append("3");
            }
            i--;
        }
        if (i < 1) {
            if (index != 0) {
                sb.insert(0, 3);
            }
            return true;
        } else {
            sb.insert(0, i);
            return false;
        }
    }
}
