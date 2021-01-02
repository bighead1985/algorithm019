import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 反转单词
 * User: liqing@pluosi
 * Date: 2021-01-01
 * Time: 9:35 PM
 */
public class ReverseWords {

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }
}
