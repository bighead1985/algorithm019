import java.util.Arrays;

/**
 * Description: 插入排序
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * 时间复杂度:O(n^2)
 * Date: 2020-12-26
 * Time: 11:53 AM
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

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new InsertionSort().insertionSort(new int[]{1, 4, 3, 7, 2, 10, 5, 21, 6})));

    }
}
