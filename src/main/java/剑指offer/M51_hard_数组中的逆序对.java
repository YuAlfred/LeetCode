package 剑指offer;

import java.util.Arrays;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/19 0:02
 * @description : 剑指 Offer 51. 数组中的逆序对
 * @modified By  :
 */
public class M51_hard_数组中的逆序对 {

    public static void main(String[] args) {
        M51_hard_数组中的逆序对 m = new M51_hard_数组中的逆序对();
        System.out.println(m.reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] arr, int start, int end) {
        int count = 0;
        if (start >= end) {
            return count;
        }
        int mid = (start + end) / 2;
        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);

        count += merge(arr, start, mid, end);
        return count;
    }

    public int merge(int[] arr, int start, int mid, int end) {
        int i = 0, j = mid + 1, k = start;
        int[] temp = Arrays.copyOfRange(arr, start, j);
        int count = 0;
        while (i < temp.length && j <= end) {
            count += temp[i] <= arr[j] ? j - mid - 1 : 0;
            arr[k++] = temp[i] <= arr[j] ? temp[i++] : arr[j++];
        }
        while (i < temp.length) {
            count += j - mid - 1;
            arr[k++] = temp[i++];
        }
        while (j <= end) {
            arr[k++] = arr[j++];
        }
        return count;
    }

}
