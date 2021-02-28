package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 22. 括号生成-回溯
 * User: liqing@pluosi
 * Date: 2021-02-13
 * Time: 11:06 AM
 */
public class GenerateParenthesisI {

    int max = 0;

    public List<String> generateParenthesis(int n) {
        max = n;
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close) {

        //如果当前括号序列长度已经达到要求，则返回
        if(cur.length() == max * 2){
            ans.add(cur.toString());
            return;
        }

        //如果左括号的数量小于max，则继续添加一个左括号
        if(open < max){
            cur.append("(");
            backtrack(ans,cur,open+1,close);
            cur.deleteCharAt(cur.length()-1);
        }

        //如果左括号的数量小于max，则继续添加一个左括号
        if(close < open){
            cur.append(")");
            backtrack(ans,cur,open,close+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
