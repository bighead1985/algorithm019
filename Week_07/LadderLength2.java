import java.util.*;

/**
 * Description: 单词接龙解法2
 * 在解法1的基础上，将visited集合修改为boolean数组，减少查找时间
 * User: liqing
 * Date: 2020-12-20
 * Time: 12:37 PM
 */
public class LadderLength2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        /**
         * 1.参数判断：worldList不包含endWord，其它的非空判断可以忽略
         */
        if (!wordList.contains(endWord)) {
            return 0;
        }


        /**
         * 2.初始化
         * - BFS需要的集合：visited，queue，并把起始词添加到2个集合中
         * - 用来返回结果的count计数器
         */
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            visited[idx] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;

        /**
         * 3. 开始BFS过程
         * - 已经访问过的不需要再访问
         * - 判断是否通过替换一个单词能变成字典里的词语
         * - 如果能够完全匹配endWord，则return count+1
         * - 添加当前词语到visited和queue
         */

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (int j = 0;j< wordList.size();j++) {
                    String s = wordList.get(j);
                    if (visited[j]) {
                        continue;
                    }

                    if (!canConvert(start, s)) {
                        continue;
                    }

                    if (s.equals(endWord)) {
                        return count + 1;
                    }

                    visited[j] = true;
                    queue.offer(s);
                }

            }


        }
        return 0;

    }

    public boolean canConvert(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        /**
         * "hit"
         * "cog"
         * ["hot","dot","dog","lot","log","cog"]
         */
        System.out.println(new LadderLength2().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
