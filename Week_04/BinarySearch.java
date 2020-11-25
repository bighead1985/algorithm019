/**
 * Description: 二分查找法
 * Date: 2020-11-25
 * Time: 10:35 PM
 */
public class BinarySearch {


    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7));
    }
}
