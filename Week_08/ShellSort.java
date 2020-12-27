import java.util.Arrays;

/**
 * Description: 希尔排序
 *
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序
 * 希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列
 * 时间复杂度:O(n^1.3)
 * Date: 2020-12-26
 * Time: 11:53 AM
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

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new ShellSort().shellSort(new int[]{1, 4, 3, 7, 2, 10, 5, 21, 6})));

    }
}
