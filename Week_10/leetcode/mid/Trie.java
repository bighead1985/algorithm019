package leetcode.mid;

/**
 * Description: 实现前缀树
 * User: liqing@pluosi
 * Date: 2021-01-09
 * Time: 11:04 AM
 */
public class Trie {

    boolean isEnd = false;
    Trie[] next = new Trie[26];

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     * 遍历word字符串
     * 1) 当next数组的当前字符索引处为空时，new一个Trie()节点
     * 2）当next数组的当前字符索引处不为空，将cur指针移动到下一个节点处 cur = cur.next[ch-'a']
     */
    public void insert(String word) {
        Trie cur = this;
        for (char ch : word.toCharArray()) {
            if (cur.next[ch - 'a'] == null) {
                cur.next[ch - 'a'] = new Trie();
            }
            cur = cur.next[ch - 'a'];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     * 遍历word字符串,如果node的下一个字符节点为空，则直接返回false，否则继续移动，直到达到最后一个节点，并判断isEnd是否为true
     */
    public boolean search(String word) {

        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * 与search方法逻辑完全一直，但当遍历到最后一个节点时，不需要判断是否为叶子节点
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;

    }
}
