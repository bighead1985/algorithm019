package leetcode.mid.dfs;

/**
 * Description: 130. 被围绕的区域
 * User: liqing@pluosi
 * Date: 2021-02-09
 * Time: 10:00 PM
 */
public class Solve {

    public void solve(char[][] board) {

        int r = board.length;
        if (r < 1) {
            return;
        }
        int c = board[0].length;

        //将边界上的0及其连通区域全部变成"#"
        for (int i = 0; i < r; i++) {
            //第一行和最后一行边界
            if (i == 0 || i == r - 1) {
                for (int j = 0; j < c; j++) {
                    filldfs(i, j, board, r, c);
                }
            }

            //对于中间行来说，只需要处理第一列和最后一列
            filldfs(i, 0, board, r, c);
            filldfs(i, c - 1, board, r, c);

        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    private void filldfs(int i, int j, char[][] board, int r, int c) {

        if (i < 0 || j < 0 || i >= r || j >= c || board[i][j] == '#' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';
        //左
        filldfs(i - 1, j, board, r, c);
        //上
        filldfs(i, j + 1, board, r, c);
        //右
        filldfs(i + 1, j, board, r, c);
        //下
        filldfs(i, j - 1, board, r, c);
    }
}
