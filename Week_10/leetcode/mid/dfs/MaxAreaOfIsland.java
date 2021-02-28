package leetcode.mid.dfs;

/**
 * Description: 695. 岛屿的最大面积
 * User: liqing@pluosi
 * Date: 2021-02-17
 * Time: 10:42 AM
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int row = grid.length;
        if (row <= 0) {
            return 0;
        }
        int col = grid[0].length;
        //可以不使用boolean数组，通过将访问过的区域打成0来节省空间
        //boolean[][] used = new boolean[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                //if (!used[i][j]) {
                    if (grid[i][j] == 1) {
                        ans = Math.max(ans, dfs(grid, i, j));
                    }
                //}
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = 0;
        int area = 1;

        area += dfs(grid, i + 1, j);
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i, j - 1);

        return area;

    }
}
