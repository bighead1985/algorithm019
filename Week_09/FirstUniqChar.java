import java.util.HashMap;
import java.util.Map;

/**
 * Description: 字符串中的第一个唯一字符
 * User: liqing
 * Date: 2021-01-01
 * Time: 8:26 PM
 */
public class FirstUniqChar {


    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));
    }

}
