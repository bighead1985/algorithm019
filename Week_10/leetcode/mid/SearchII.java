package leetcode.mid;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2021-01-25
 * Time: 7:18 PM
 */
public class SearchII {
    public boolean search(int[] nums, int target) {

        if (null == nums || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return true;
            }

            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }


            if (nums[start] < nums[mid]) {

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
        return false;

    }
}
