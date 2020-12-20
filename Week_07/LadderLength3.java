import java.util.*;


/**
 * Description: 单词接龙解法3
 * 在解法1的基础上进行双向BFS求解
 * User: liqings
 * Date: 2020-12-20
 * Time: 12:37 PM
 */
public class LadderLength3 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        // 用于 BFS 遍历的队列
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        // 用于保存已访问的单词
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count1 = 0;
        int count2 = 0;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count1++;
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = wordList.get(queue1.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited1.contains(i)) {
                        continue;
                    }
                    if (!canConvert(s, wordList.get(i))) {
                        continue;
                    }
                    if (visited2.contains(i)) {
                        return count1 + count2 + 1;
                    }
                    visited1.add(i);
                    queue1.offer(i);
                }
            }
            count2++;
            int size2 = queue2.size();
            while (size2-- > 0) {
                String s = wordList.get(queue2.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited2.contains(i)) {
                        continue;
                    }
                    if (!canConvert(s, wordList.get(i))) {
                        continue;
                    }
                    if (visited1.contains(i)) {
                        return count1 + count2 + 1;
                    }
                    visited2.add(i);
                    queue2.offer(i);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++count > 1) {
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
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(new LadderLength3().ladderLength("hit", "cog",list));
    }
}
