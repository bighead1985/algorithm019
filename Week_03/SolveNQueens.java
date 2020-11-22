
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description:N皇后
 * Date: 2020-11-18
 * Time: 10:09 PM
 */
public class SolveNQueens {


    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        if (n == 0) {
            return res;
        }

        //记录每一列上是否放置了皇后
        boolean[] col = new boolean[n];

        //记录主对角线上是否放置了皇后
        boolean[] main = new boolean[2 * n - 1];

        //记录副对角线上是否放置了皇后
        boolean[] sub = new boolean[2 * n - 1];

        //存储皇后
        Deque<Integer> path = new ArrayDeque<>();

        dfs(0, n,path,res,col,main,sub);

        return res;


    }

    private void dfs(int row,int n, Deque<Integer> path,List<List<String>> res,boolean[] col,boolean[] main,boolean[] sub) {

        //terminator
        if (row == n) {
            List<String> board = convert2board(path,n);
            res.add(board);
            return;
        }

        for (int j = 0; j < n; j++) {
            //process
            if (!col[j] && !main[row - j + n - 1] && !sub[row + j]) {
                path.addLast(j);
                col[j] = true;
                main[row - j + n - 1] = true;
                sub[row + j] = true;


                dfs(row + 1,n, path,res,col,main,sub);


                //restore
                sub[row + j] = false;
                main[row - j + n - 1] = false;
                col[j] = false;
                path.removeLast();

            }
        }

    }

    /**
     * 将皇替换成字符Q
     * @param path
     * @param n
     * @return
     */
    private List<String> convert2board(Deque<Integer> path,int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(String.format("%0" + n + "d", 0).replace("0", "."));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(4));
    }

}
