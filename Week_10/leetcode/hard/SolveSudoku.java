package leetcode.hard;

/**
 * Description: 37. 解数独
 * User: liqing@pluosi
 * Date: 2021-02-13
 * Time: 12:17 PM
 */
public class SolveSudoku {

    boolean solved = false;
    int[][] row = new int[9][9];
    int[][] col = new int[9][9];
    int[][] block = new int[9][9];

    public void solveSudoku(char[][] board) {

        //根据棋盘当前状态初始化row,col,block
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                //计算block索引
                int index = (i / 3) * 3 + j / 3;
                int num = board[i][j] - '0';
                row[i][num - 1] = col[j][num - 1] = block[index][num - 1] = 1;
            }
        }
        backtrack(board, 0, 0);


    }

    /**
     * 回溯方法
     *
     * @param board
     * @param i
     * @param j
     */
    private void backtrack(char[][] board, int i, int j) {

        if (i == 9) {
            solved = true;
            return;
        }
        // 如果有数字
        if (board[i][j] != '.') {
            if (j < 8) {
                backtrack(board, i, j + 1);
            } else {
                backtrack(board, i + 1, 0);
            }
        //如果没有数字，则使用回溯法进行填充
        } else {
            int index = (i / 3) * 3 + j / 3;
            for (int k = 1; k <= 9; k++) {
                //如果在行、列、块 中都没有使用
                if (row[i][k - 1] == 0 && col[j][k - 1] == 0 && block[index][k - 1] == 0) {
                    board[i][j] = (char) (k + '0');
                    row[i][k - 1] = col[j][k - 1] = block[index][k - 1] = 1;
                    // 继续下一个
                    if (j < 8) {
                        backtrack(board, i, j + 1);
                    } else {
                        backtrack(board, i + 1, 0);
                    }
                    // 如果没有解决 那么回溯,将之前修改的状态重置
                    if (!solved) {
                        board[i][j] = '.';
                        row[i][k - 1] = col[j][k - 1] = block[index][k - 1] = 0;
                    }
                }
            }

        }
    }
}
