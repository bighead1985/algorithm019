package leetcode.simple;


/**
 * Description:
 * User: liqing@pluosi
 * Date: 2021-01-20
 * Time: 9:40 PM
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;

    }
}
