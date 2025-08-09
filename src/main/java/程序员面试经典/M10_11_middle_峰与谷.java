package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/24 6:47 下午
 * @description : 面试题 10.11. 峰与谷
 * @modified By  :
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 6, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * <p>
 * 示例:
 * <p>
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 * 提示：
 * <p>
 * nums.length <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peaks-and-valleys-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M10_11_middle_峰与谷 {

    public void wiggleSort(int[] nums) {
        int signal = -1;
        for (int i = 0; i < nums.length - 1; i++, signal = -signal) {
            if ((nums[i] - nums[i + 1]) * signal < 0) {
                int t = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = t;
            }
        }
    }


}









