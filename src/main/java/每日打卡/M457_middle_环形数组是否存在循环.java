package 每日打卡;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 457. 环形数组是否存在循环
 * @date: 2021/8/7 11:26 上午
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * <p>
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果 nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * <p>
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * <p>
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * 示例 3:
 * <p>
 * 输入：nums = [-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
 * 所有 nums[seq[j]] 应当不是全正就是全负。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 *  
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circular-array-loop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M457_middle_环形数组是否存在循环 {

    public static void main(String[] args) {

        // System.out.println(2 ^ 2);

        M457_middle_环形数组是否存在循环 m = new M457_middle_环形数组是否存在循环();
        System.out.println(m.circularArrayLoop(new int[]{1, 1, 2}));

    }


    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 快慢指针
            int slow = i, fast = next(nums, i, n);
            // 只要非0且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast, n)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow, n)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow, n);
                fast = next(nums, next(nums, fast, n), n);
            }
            // 直到方向不一致前都设为0
            int cur = i;
            while (nums[cur] * nums[next(nums, cur, n)] > 0) {
                int next = next(nums, cur, n);
                nums[cur] = 0;
                cur = next;
            }
        }
        return false;
    }

    public int next(int[] nums, int i, int n) {
        return ((i + nums[i]) % n + n) % n;
    }

}
