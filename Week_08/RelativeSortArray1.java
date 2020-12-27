import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 数组的相对位置
 * 使用自定义比较函数实现
 * Date: 2020-12-27
 * Time: 10:54 AM
 */
public class RelativeSortArray1 {

    Map<Integer,Integer> record;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {


        record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }

        List<Integer> res = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        Collections.sort(res, (num1, num2) -> {
            if (record.containsKey(num1) || record.containsKey(num2)) {
                return record.getOrDefault(num1, 1000) - record.getOrDefault(num2, 1000);
            } else {
                return num1 - num2;
            }
        });

        return res.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};

        System.out.println(Arrays.toString(new RelativeSortArray1().relativeSortArray(arr1, arr2)));
    }
}
