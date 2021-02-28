package leetcode.mid.dfs;

/**
 * Description: 200. 岛屿数量
 * User: liqing@pluosi
 * Date: 2021-02-17
 * Time: 10:26 AM
 */
public class NumIslands {

    public int numIslands(char[][] grid) {

        int row = grid.length;
        if (row <= 0) {
            return 0;
        }
        int col = grid[0].length;
        int count = 0;
        boolean[][] used = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (!used[i][j]) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j, used);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] used) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || used[i][j]) {
            return;
        }

        used[i][j] = true;
        dfs(grid, i + 1, j, used);
        dfs(grid, i - 1, j, used);
        dfs(grid, i, j + 1, used);
        dfs(grid, i, j - 1, used);

    }

}
