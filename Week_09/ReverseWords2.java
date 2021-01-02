import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 反转单词2
 * User: liqing@pluosi
 * Date: 2021-01-01
 * Time: 9:35 PM
 */
public class ReverseWords2 {

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        StringBuffer sb = new StringBuffer();
        for (String word : wordList) {
            sb.append(new StringBuilder(word).reverse().toString().trim()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords2().reverseWords("Let's take LeetCode contest"));
    }
}
