package 每日打卡;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/9/5 18:05
 * @description : 60. 第k个排列
 * @modified By  :
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M60_middle_第k个排列 {

    public static void main(String[] args) {
        getPermutation(3, 3);
    }

    public static int[] times;

    public static String getPermutation(int n, int k) {
        times = new int[10];
        times[1] = 1;
        for (int i = 2; i < 10; i++) {
            times[i] = i * times[i - 1];
        }
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        rec(nums, res, k);
        StringBuilder sb = new StringBuilder();
        for (Integer s : res) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void rec(List<Integer> nums, List<Integer> res, int k) {
        if (nums.size() == 1) {
            res.add(nums.get(0));
            nums.remove(0);
            return;
        }
        int time = times[nums.size() - 1];
        int i = 0;
        while (k > time) {
            k -= time;
            i++;
        }
        res.add(nums.get(i));
        nums.remove(i);
        rec(nums, res, k);
    }


}















