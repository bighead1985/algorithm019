package leetcode.mid.dfs;

/**
 * Description: 74.搜索二维矩阵
 * User: liqing@pluosi
 * Date: 2021-01-28
 * Time: 11:01 PM
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int star_row = 0;
        int end_row = row - 1;

        while (star_row <= end_row) {
            int mid_row = star_row + (end_row - star_row) / 2;
            if (target == matrix[mid_row][0]) {
                return true;
            }
            if (target > matrix[mid_row][0]) {
                star_row = mid_row + 1;
            } else {
                end_row = mid_row - 1;
            }

            if (searchRow(target, matrix[mid_row])) {
                return true;
            }
        }

        return false;
    }

    private boolean searchRow(int target, int[] matrix) {

        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == matrix[mid]) {
                return true;
            }
            if (target > matrix[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;

    }
}
