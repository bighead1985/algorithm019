import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Description: 滑动谜题
 * Date: 2020-12-19
 * Time: 10:58 PM
 */
public class SlidingPuzzle {

    int slidingPuzzle(int[][] board) {

        int m = 2, n = 3;
        String start = "";
        String target = "123450";

        // 将 2x3 的数组转化成字符串
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start = start +board[i][j];
            }
        }
        // 记录一维字符串的相邻索引
        int[][] neighbor = new int[][]{
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };

        /******* BFS 算法框架开始 *******/
        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet();

        q.offer(start);
        visited.add(start);

        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                // 判断是否达到目标局面
                if (target.equals(cur)) {
                    return step;
                }

                // 找到数字 0 的索引
                int idx = 0;
                while(cur.charAt(idx) != '0'){
                    idx++;
                }
                // 将数字 0 和相邻的数字交换位置
                for (int adj : neighbor[idx]) {
                    char[] new_board = cur.toCharArray();
                    char tmp = new_board[adj];
                    new_board[adj] = new_board[idx];
                    new_board[idx] = tmp;

                    // 防止走回头路
                    String newBoard = new String(new_board);
                    if (!visited.contains(newBoard)) {
                        q.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
        /******* BFS 算法框架结束 *******/
    }

    public static void main(String[] args) {

        System.out.println(new SlidingPuzzle().slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
    }
}
