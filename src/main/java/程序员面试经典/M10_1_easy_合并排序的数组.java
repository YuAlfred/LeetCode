package 程序员面试经典;

import java.util.Arrays;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/24 6:39 下午
 * @description : 面试题 10.01. 合并排序的数组
 * @modified By  :
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M10_1_easy_合并排序的数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] temp = Arrays.copyOf(A, m);
        int i = 0, j = 0, p = 0;
        while (i < m && j < n) {
            if (temp[i]<B[j]){
                A[p] = temp[i];
                p++;
                i++;
            }else {
                A[p] = B[j];
                p++;
                j++;
            }
        }
        while (i < m) {
            A[p] = temp[i];
            p++;
            i++;
        }
        while (j < n) {
            A[p] = B[j];
            p++;
            j++;
        }
    }
}







