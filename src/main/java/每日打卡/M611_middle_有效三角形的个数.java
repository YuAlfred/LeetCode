package 每日打卡;

import java.util.Arrays;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 611. 有效三角形的个数
 * @date: 2021/8/4 12:10 上午
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 * <p>
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M611_middle_有效三角形的个数 {

    public static void main(String[] args) {
        M611_middle_有效三角形的个数 m = new M611_middle_有效三角形的个数();
        System.out.println(m.triangleNumber(new int[]{2, 2, 3, 4}));
    }

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int l = j + 1, r = nums.length - 1;
                int max = nums[i] + nums[j];
                while (r >= l) {
                    int middle = (l + r) / 2;
                    if (nums[middle] < max) {
                        l = middle + 1;
                    } else {
                        r = middle - 1;
                    }
                }
                ans += r - j;
            }
        }

        return ans;
    }

    public int find(int[] nums, int max, int min) {
        if (nums.length == 0) {
            return 0;
        }
        int left = Arrays.binarySearch(nums, min);
        if (left < 0) {
            left = -left - 1;
        }
        int right = Arrays.binarySearch(nums, max);
        if (right < 0) {
            right = -right - 2;
        }

        return Math.max((right - left + 1), 0);

    }


}
