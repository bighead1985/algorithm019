import java.util.*;

/**
 * 49. 字母异位词分组
 * Date: 2020-11-15
 * Time: 11:00 AM
 *
 */
public class GroupAnagrams {

        public List<List<String>> groupAnagrams(String[] strs) {


            Map<String,List<String>> map = new HashMap<>();

            for(String s:strs){
                String key = key(s);
                List<String> values = map.get(key);
                if(null == values){
                    values = new ArrayList<>();
                }
                values.add(s);
                map.put(key(s),values);
            }

            return new ArrayList<>(map.values());

        }

        private String key(String str){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}) );
    }

}
