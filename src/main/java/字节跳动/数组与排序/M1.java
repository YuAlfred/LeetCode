package 字节跳动.数组与排序;

import java.util.*;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/12 16:52
 * @description : 三数之和
 * @modified By  :
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class M1 {


    public static void main(String[] args) {
        M1 m1 = new M1();
        m1.threeSum(new int[]{0, 0, 0, 0});
        System.out.println();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //先给进来的数排序
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> meta;

        int pre = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (nums[i] == pre) {
                continue;
            } else {
                pre = nums[i];
            }
            for (int j = i + 1, k = nums.length - 1; j < nums.length && (nums[i] + nums[j]) <= 0; j++) {
                for (; k > j && (nums[i] + nums[j] + nums[k]) >= 0; k--) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {

                        meta = new ArrayList<>(3);
                        meta.add(nums[i]);
                        meta.add(nums[j]);
                        meta.add(nums[k]);
                        if (!result.isEmpty()&&same(meta, result.get(result.size() - 1))) {
                            continue;
                        }
                        result.add(meta);
                    }
                }
            }


        }

        return result;
    }

    public boolean same(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < 3; i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 归并排序
     *
     * @param nums
     * @param start
     * @param end
     */
    public void sort(int[] nums, int start, int end) {
        //归并排序

        if (start >= end) {
            return;
        }

        sort(nums, start, (end + start) / 2);
        sort(nums, (end + start) / 2 + 1, end);
        merge(nums, start, end);

    }

    public void merge(int[] nums, int start, int end) {

        //merge部分复制一个拷贝
        int[] copy = Arrays.copyOfRange(nums, start, end + 1);


        int l = 0;
        int length = copy.length - 1;
        int mid = (l + length) / 2;
        int r = mid + 1;
        int p = start;

        while (l <= mid && r <= length) {
            if (copy[l] < copy[r]) {
                nums[p] = copy[l];
                p++;
                l++;
            } else {
                nums[p] = copy[r];
                p++;
                r++;
            }
        }

        while (l <= mid) {
            nums[p] = copy[l];
            p++;
            l++;
        }

        while (r <= length) {
            nums[p] = copy[r];
            p++;
            r++;
        }

    }

}
