/**
 * Description: 数组的相对位置
 * 使用计数排序实现
 * Date: 2020-12-27
 * Time: 10:54 AM
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //初始化计数桶
        int[] bucket = new int[1001];
        for (int num1 : arr1) {
            bucket[num1]++;
        }

        //按照arr2的相对顺序按照计数排序的规则来进行排序
        int idx = 0;
        for (int num2 : arr2) {
            while (bucket[num2] > 0) {
                arr1[idx++] = num2;
                bucket[num2]--;
            }
        }

        //将剩余的数放在arr1的末尾
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr1[idx++] = i;
                bucket[i]--;
            }
        }

        return arr1;

    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};

        System.out.println(new RelativeSortArray().relativeSortArray(arr1, arr2));
    }
}
