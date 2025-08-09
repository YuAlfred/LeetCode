package 面试笔试.字节跳动.数组与排序;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/15 21:16
 * @description : 第k个排列
 * @modified By  :
 */
public class M7 {

    public static void main(String[] args) {
        M7 m7 = new M7();
        m7.getPermutation(3, 2);
    }

    public String getPermutation(int n, int k) {

        StringBuffer bf = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            bf.append(i);
        }
        StringBuffer result = recursion(bf, n, k);

        return result.toString();

    }

    public StringBuffer recursion(StringBuffer nums, int n, int k) {

        if (n == 1 || k == 1) {
            return nums;
        }

        // 计算阶乘
        int multi = 1;
        for (int i = 1; i < n; i++) {
            multi *= i;
        }

        int p = (k - 1) / multi;
//        if (p == n) {
//            return nums.reverse();
//        }

        char pre = nums.charAt(p);
        nums.deleteCharAt(p);

        StringBuffer result = recursion(nums, n - 1, k - (multi * p));

        return result.insert(0, pre);

    }

}
