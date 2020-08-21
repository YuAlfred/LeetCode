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

    public int reversePairs(int[] nums) {
        return 0;
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);


    }

    public void merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, start, end);
    }

}
