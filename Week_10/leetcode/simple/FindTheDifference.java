package leetcode.simple;

import java.util.Arrays;

/**
 * Description: 找不同
 * User: liqing@pluosi
 * Date: 2021-01-06
 * Time: 10:51 PM
 */
public class FindTheDifference {

      //字符串替换
//    public char findTheDifference(String s, String t) {
//
//        if (s.length() <= 0) {
//            return t.toCharArray()[0];
//        }
//
//        for (char schar : s.toCharArray()) {
//            t = t.replaceFirst("" + schar, "");
//        }
//        return t.toCharArray()[0];
//    }

     //ASCII码相减
//    public char findTheDifference(String s, String t) {
//        int as = 0, at = 0;
//        for (int i = 0; i < s.length(); ++i) {
//            as += s.charAt(i);
//        }
//        for (int i = 0; i < t.length(); ++i) {
//            at += t.charAt(i);
//        }
//        return (char) (at - as);
//    }


    //位运算
    public char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

    public static void main(String[] args) {
        new FindTheDifference().findTheDifference("a", "aa");
    }
}
