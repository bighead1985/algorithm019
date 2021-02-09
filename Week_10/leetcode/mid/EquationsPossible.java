package leetcode.mid;

/**
 * Description: 等式方程的可满足性
 * User: liqing@pluosi
 * Date: 2021-02-02
 * Time: 7:17 PM
 */
public class EquationsPossible {

    public boolean equationsPossible(String[] equations) {

        /**
         * 1.初始化并查集数组
         */
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        /**
         * 对处于"="两边的字符串进行并查集的合并操作：
         * 将第一个节点的根节点父节点指向第二个节点的根节点
         */
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }

        /**
         * 如果处于不等式两边的字符串在一个集合内，则返回false
         */
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;


    }

    /**
     * 合并两个节点
     *
     * @param parent
     * @param index1
     * @param index2
     */
    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 查找某个节点所在集合的根节点
     *
     * @param parent
     * @param index
     * @return
     */
    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
