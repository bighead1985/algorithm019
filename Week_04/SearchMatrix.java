/**
 * Description:
 * User: liqing@pluosi
 * Date: 2020-11-29
 * Time: 3:20 PM
 */
public class SearchMatrix {


    int row;
    int col;

    public boolean searchMatrix(int[][] matrix, int target) {


        /**
         * 先用二分搜索法定位到行，然后在每一行再用二分搜索法
         */

        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        row = matrix.length;
        col = matrix[0].length;

        /**
         * 定位行
         */
        int row_left = 0;
        int row_right = row - 1;
        int mid_row = 0;

        while (row_left <= row_right) {

            mid_row = (row_left + row_right) / 2;

            if (target == matrix[mid_row][0]) {
                return true;
            }

            if (target > matrix[mid_row][0]) {
                row_left = mid_row + 1;
            } else {
                row_right = mid_row - 1;
            }

            if (search(target, matrix[mid_row])) {
                return true;
            }
        }

        return false;


    }

    private boolean search(int target, int[] curRrow) {

        int left = 0;
        int right = col - 1;
        int mid = 0;


        while (left <= right) {
            mid = (left + right) / 2;
            if (target == curRrow[mid]) {
                return true;
            }

            if (target > curRrow[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return target == curRrow[mid];

    }
}
