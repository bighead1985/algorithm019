import java.util.Arrays;

/**
 * Description:计数排序
 * <p>
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数
 * <p>
 * Date: 2020-12-26
 * Time: 6:29 PM
 */
public class CountingSort {

    public static void countingSort(int[] arr, int maxValue) {

        int[] bucket = new int[maxValue + 1];

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }


        int idx = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                arr[idx++] = j;
                bucket[j]--;
            }
        }

    }

    public static void main(String[] args) {
        CountingSort.countingSort(SortConfig.arr, 21);
        System.out.println(Arrays.toString(SortConfig.arr));
    }
}
