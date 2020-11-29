/**
 * Description:
 * User: liqing@pluosi
 * Date: 2020-11-28
 * Time: 1:12 PM
 */
public class NumIslands {

    /**
     * 定义成员变量
     * 1.定义4个方向：上下左右
     * 2.visted数组
     * 3.行，列指针
     * 4.整个地图的二维数组grid
     */
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    int rows;
    int cols;
    char[][] grids;


    /**
     * 主方法：
     * 1.参数校验
     * 2.根据入参初始化行列指针
     * 3.遍历二位数组，如果当前元素没被访问够且==1，继续深度遍历递归，count++
     */

    public int numIslands(char[][] grid) {

        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int count = 0;
        cols = grid[0].length;

        this.grids = grid;
        visited = new boolean[rows][cols];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {

                if (!visited[x][y] && grids[x][y] == '1') {
                    dfs(x, y);
                    count++;
                }
            }
        }

        return count;


    }


    /**
     * 深度遍历子方法：
     * 1.访问数组放置为true
     * 2.如果没有被访问过，没有越界，并且四个方向上都为1，继续递归
     */
    private void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int moveX = x + directions[i][0];
            int moveY = y + directions[i][1];
            if (inArea(moveX, moveY) && !visited[moveX][moveY] && grids[moveX][moveY] == '1' ) {
                dfs(moveX, moveY);
            }

        }
    }

    /**
     * 判断当坐标是否越界
     *
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        System.out.println(new NumIslands().numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }

}
