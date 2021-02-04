package leetcode.simple;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2021-01-21
 * Time: 10:13 PM
 */
public class SortedSquares {

    public int[] sortedSquares(int[] A) {

        int n = A.length;
        int[] res = new int[n];

        for (int i = 0, j = A.length - 1, pos = n; i <= j; ) {

            if (A[i] * A[i] > A[j] * A[j]) {
                res[pos] = A[i] * A[i];
                i++;
            } else {
                res[pos] = A[j] * A[j];
                j--;
            }
            pos--;

        }
        return res;

    }
}
