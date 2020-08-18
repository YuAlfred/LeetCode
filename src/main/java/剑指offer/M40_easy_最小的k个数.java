package 剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/16 18:10
 * @description : 剑指 Offer 40. 最小的k个数
 * @modified By  :
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 通过次数83,772提交次数146,354
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M40_easy_最小的k个数 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}





