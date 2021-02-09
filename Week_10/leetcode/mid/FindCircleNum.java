package leetcode.mid;

/**
 * Description: 省份数量(朋友圈数量)
 * User: liqing@pluosi
 * Date: 2021-02-02
 * Time: 7:35 PM
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {

        int[] parent = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int circles = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;

    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
