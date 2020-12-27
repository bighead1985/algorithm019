import java.util.Arrays;

/**
 * Description: 冒泡排序
 *
 * 进行n轮交换，每一轮将较大的数跟后面的数交换，直到将最大的数放到数组的末尾
 * 时间复杂度:O(n^2)
 *
 * Date: 2020-12-26
 * Time: 11:22 AM
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

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(new int[]{1,4,3,7,2,10,5,21,6})));

    }

}
