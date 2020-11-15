/**
 * 242. 有效的字母异位词
 * Date: 2020-11-15
 * Time: 10:41 AM
 */
public class IsAnagram {

        public boolean isAnagram(String s, String t) {

            int[] result = new int[26];

            if (s.length() != t.length()) {
                return false;
            }

            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();
            int len = s.length();

            for (int i = 0; i < len; i++) {
                result[schars[i] - 'a']++;
                result[tchars[i] - 'a']--;
            }

            for (int i : result) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("anagrim","nagaram"));

    }
}
