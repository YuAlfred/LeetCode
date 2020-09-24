package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/23 2:59 下午
 * @description : 面试题 16.16. 部分排序
 * @modified By  :
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * <p>
 * 示例：
 * <p>
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 * <p>
 * 0 <= len(array) <= 1000000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_16_middle_部分排序 {

    public static void main(String[] args) {
        subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }

    public static int[] subSort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return new int[]{-1, -1};
        }
        int m = -1, n = array.length;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int t = i - 1;
                while (t >= 0 && array[t] > array[i]) {
                    t--;
                }
                t++;
                if (m == -1) {
                    m = t;
                } else {
                    m = Math.min(m, t);
                }
            }
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                int t = i + 1;
                while (t <= array.length - 1 && array[t] < array[i]) {
                    t++;
                }
                t--;
                if (n == array.length) {
                    n = t;
                } else {
                    n = Math.max(n, t);
                }
            }
        }
        if (m == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{m, n};
        }
    }

}









