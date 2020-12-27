/**
 * Description:
 * User: liqing@pluosi
 * Date: 2020-12-27
 * Time: 10:52 AM
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {

        int[] bucket = new int[26];

        char[] s_chars = s.toCharArray();
        for (char c : s_chars) {
            bucket[c - 'a']++;
        }

        char[] t_chars = t.toCharArray();
        for (char c : t_chars) {
            bucket[c - 'a']--;
        }

        for (int i : bucket) {
            if (i != 0) {
                return false;
            }
        }

        return true;

    }
}
