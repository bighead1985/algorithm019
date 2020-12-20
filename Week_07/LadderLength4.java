import java.util.*;


/**
 * Description: 单词接龙解法4
 * 对单词判断进行剪枝优化，有2个思路
 * 思路1：遍历所有候选单词，判断当前单词是否可以转换成这个候选单词。判断的过程也就是前面的canConvert方法，逐个对比单词的字符。
 * 思路2：因为单词是由 a~z 这有限数量的字符组成的，可以遍历当前单词能转换成的所有单词，判断其是否包含在候选单词中。候选单词用 HashSet 保存，可以大大提高判断包含关系的性能
 *
 * 当单词总数量庞大的时候，之前代码用到的思路1耗时就会很长
 * 一般单词不会很长，字符也是固定的 26 个小写字母，因此思路2的性能会好很多
 *
 * User: liqings
 * Date: 2020-12-20
 * Time: 12:37 PM
 */
public class LadderLength4 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);

        // 从两端 BFS 遍历要用的队列
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length(); ++j) {
                    // 保存第j位的原始字符
                    char c_tmp = chars[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newString = new String(chars);
                        // 已经访问过了，跳过
                        if (visited1.contains(newString)) {
                            continue;
                        }
                        // 两端遍历相遇，结束遍历，返回 count
                        if (visited2.contains(newString)) {
                            return count + 1;
                        }
                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                        if (allWordSet.contains(newString)) {
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    // 恢复第j位的原始字符
                    chars[j] = c_tmp;
                }
            }
        }
        return 0;
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
        System.out.println(new LadderLength4().ladderLength("hit", "cog",list));
    }
}
