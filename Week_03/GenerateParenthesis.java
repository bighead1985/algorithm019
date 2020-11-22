import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2020-11-16
 * Time: 11:02 PM
 */
public class GenerateParenthesis {

    private List<String> result;

    public List<String> generateParenthesis(int n) {

        result = new ArrayList<String>();
        _generate(0,0,n,"");
        return result;
    }

    private void _generate(int left, int right,int n, String s){

        if(left==n && right == n){
            result.add(s);
        }

        if(left<n){
            _generate(left+1,right,n,s+"(");
        }

        if(left > right){
            _generate(left,right+1,n,s+")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
