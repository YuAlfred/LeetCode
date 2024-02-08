package 面试笔试.字节飞书2022_2_27;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2022/2/27 6:35 PM
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.close();

        List<Integer> ans = new LinkedList<>();
        int odd = 1, event = 2;

        // 先插奇数
        while (odd <= n) {
            ans.add(odd);
            odd += 2;
        }
        // 然后依次插入偶数
        int curP = ans.size() - 1;
        while (k > 2) {
            ans.add(curP, event);
            k -= 2;
            curP--;
            event += 2;
        }
        // 最后差两对且偶数只剩一个 中间放偶数
        if (k == 2 && (event + 2) > n) {
            ans.add(curP, event);
            event += 2;
        } else if (k == 2) {
            // 最后差两对且偶数不只剩一个 头尾放偶数
            ans.add(0, event);
            event += 2;
            ans.add(event);
            event += 2;
        } else if (k == 1) {
            // 如果还差一对的话尾放偶数
            ans.add(event);
            event += 2;
        }
        while (event <= n) {
            ans.add(event);
            event += 2;
        }

        for (int i = 0; i < ans.size() - 1; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.print(ans.get(ans.size() - 1));

    }

}
