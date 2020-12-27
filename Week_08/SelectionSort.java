import java.util.Arrays;

/**
 * Description: 旋转排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
 * 时间复杂度:O(n^2)
 * Date: 2020-12-26
 * Time: 11:53 AM
 */
public class SelectionSort {

    int[] selectionSort(int[] arr) {

        int len = arr.length;
        int minIndex = 0;
        int tmp = 0;

        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new SelectionSort().selectionSort(new int[]{1, 4, 3, 7, 2, 10, 5, 21, 6})));

    }
}
