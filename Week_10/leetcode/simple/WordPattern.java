package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 大脑壳
 * User: liqing@pluosi
 * Date: 2021-01-07
 * Time: 11:11 PM
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] arr = s.split(" ");
        //如果二者长度都不等，那么根本无法匹配 直接返回false
        if (pattern.length() != arr.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(arr[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), arr[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new WordPattern().wordPattern("abba"
                , "dog cat cat fish");
    }
}
