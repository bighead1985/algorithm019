学习笔记

###排序算法总结

```
/**
 * Description: 冒泡排序
 *
 * 进行n轮交换，每一轮将较大的数跟后面的数交换，直到将最大的数放到数组的末尾
 * 时间复杂度:O(n^2)
 */
public class BubbleSort {

    int[] bubbleSort(int[] arr){

        int len = arr.length;

        for(int i=0;i<len-1;i++){
            for(int j = 0;j<len-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }
}

/**
 * Description: 插入排序
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * 时间复杂度:O(n^2)
 */
public class InsertionSort {

    int[] insertionSort(int[] arr) {

        int len = arr.length;
        int preIndex = 0;
        int cur = 0;

        for (int i = 1; i < len; i++) {
            preIndex = i-1;
            cur = arr[i];
            while(preIndex>=0 && arr[preIndex] > cur){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = cur;
        }

        return arr;
    }

}


/**
 * Description:计数排序
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数
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

}


/**
 * Description:快速排序
 * 过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
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

}

/**
 * Description: 堆排序
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
}

/**
 * Description: 希尔排序
 *
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序
 * 希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列
 * 时间复杂度:O(n^1.3)
 */
public class ShellSort {

    int[] shellSort(int[] arr) {

        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }

}
```