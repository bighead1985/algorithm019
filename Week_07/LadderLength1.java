import java.util.*;

/**
 * Description: 单词接龙解法1-基础BFS
 * User: liqing
 * Date: 2020-12-20
 * Time: 12:37 PM
 */
public class LadderLength1 {

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
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
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
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }

                    if (!canConvert(start, s)) {
                        continue;
                    }

                    if (s.equals(endWord)) {
                        return count + 1;
                    }

                    visited.add(s);
                    queue.offer(s);
                }

            }


        }
        return 0;

    }

    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
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
        System.out.println(new LadderLength1().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
