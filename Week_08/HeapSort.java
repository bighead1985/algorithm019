import java.util.Arrays;

/**
 * Description: 堆排序
 * Date: 2020-12-26
 * Time: 6:13 PM
 */
public class HeapSort {

    int len;

    void buildMaxHeap(int[] arr) {   // 建立大顶堆
        len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    void heapify(int[] arr, int i) {     // 堆调整
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int[] heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0);
        }
        return arr;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new HeapSort().heapSort(new int[]{1,4,3,7,2,10,5,21,6})));

    }
}
