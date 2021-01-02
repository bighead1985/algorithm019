/**
 * Description:同构字符串
 * User: liqing@pluosi
 * Date: 2021-01-02
 * Time: 5:38 PM
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {

        for(int i = 0;i<s.length();i++){
            if( s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("egg","add"));
    }
}
