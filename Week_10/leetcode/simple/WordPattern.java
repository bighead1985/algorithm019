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
        String[] words = s.split(" ");

        if(words.length != pattern.toCharArray().length){
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            Character key = pattern.charAt(i);
            if(!map.containsValue(words[i])){
                map.put(key, words[i]);
            }
        }

        for (int i = 0; i < words.length; i++) {
            Character key = pattern.charAt(i);
            if (!map.containsValue(words[i]) ||!map.containsKey(key)|| !map.get(key).equals(words[i])) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        new WordPattern().wordPattern("aaa"
                , "aa aa aa aa");
    }
}
