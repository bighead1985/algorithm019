import java.util.Arrays;

/**
 * Description: 归并排序
 *
 * 采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2路归并
 *
 * 时间复杂度:O(nlogn)
 * Date: 2020-12-26
 * Time: 11:53 AM
 */
public class MergeSort {

    public static void mergeSort(int[] arr,int left,int right) {

        if (right <= left) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        //左右指针同时移动，将两边数组按由大到小的顺序进行合并
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        //如果左边的指针没移动到mid处，说明左边数组还有元素没有处理完毕，直接按顺序往后累加即可
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        //如果右边的指针没移动到mid处，说明右边数组还有元素没有处理完毕，直接按顺序往后累加即可
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
//        System.arraycopy(temp,0,arr,left,temp.length);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 4, 3, 7, 2, 10, 5, 21, 6};
        MergeSort.mergeSort(arr,0,8);
        System.out.println(Arrays.toString(arr));

    }
}
