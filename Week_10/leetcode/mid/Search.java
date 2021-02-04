package leetcode.mid;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2021-01-23
 * Time: 9:38 PM
 */
public class Search {
    public int search(int[] nums, int target) {

        if (nums.length == 0 || null == nums) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            //左边有序
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
