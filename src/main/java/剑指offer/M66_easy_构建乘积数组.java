package 剑指offer;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/8 9:08 上午
 * @description : 剑指 Offer 66. 构建乘积数组
 * @modified By  :
 * <p>
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M66_easy_构建乘积数组 {


    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] res1 = new int[a.length];
        int[] res2 = new int[a.length];
        res1[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res1[i] = a[i - 1] * res1[i - 1];
        }
        res2[res2.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            res2[i] = a[i + 1] * res2[i + 1];
            res1[i] *= res2[i];
        }
        return res1;
    }


}



















