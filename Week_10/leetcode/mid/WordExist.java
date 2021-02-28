package leetcode.mid;

/**
 * Description: 79. 单词搜索
 * User: liqing@pluosi
 * Date: 2021-02-14
 * Time: 10:50 AM
 */
public class WordExist {

    int[] dir_x = {1, -1, 0, 0};
    int[] dir_y = {0, 0, 1, -1};
    int totalx = 0;
    int totaly = 0;

    public boolean exist(char[][] board, String word) {


        totalx = board.length;
        totaly = board[0].length;
        boolean[][] visited = new boolean[totalx][totaly];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, visited, 1, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int index, int x, int y) {


        if (index == word.length()) {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < dir_x.length; i++) {
            int next_x = x + dir_x[i];
            int next_y = y + dir_y[i];
            if (next_x < 0 || next_y < 0 || next_x >= totalx || next_y >= totaly || visited[next_x][next_y]) {
                continue;
            }
            if (board[next_x][next_y] != word.charAt(index)) {
                continue;
            } else {
                if (backtrack(board, word, visited, index + 1, next_x, next_y)) {
                    return true;
                }
            }


        }

        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.print(new WordExist().exist(board, "ABCCED"));
    }


}
