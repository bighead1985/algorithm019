package leetcode.simple;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2021-01-21
 * Time: 10:22 PM
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return 0;

    }

}
