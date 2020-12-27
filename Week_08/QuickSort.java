import java.util.Arrays;

/**
 * Description:快速排序
 * 过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * Date: 2020-12-26
 * Time: 3:56 PM
 */
public class QuickSort {

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                if (i != counter) {
                    swap(a, counter, i);
                }
                counter++;
            }
        }
        swap(a, pivot, counter);
        return counter;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        QuickSort.quickSort(SortConfig.arr, 0, SortConfig.arr.length - 1);
        System.out.println(Arrays.toString(SortConfig.arr));
    }

}
