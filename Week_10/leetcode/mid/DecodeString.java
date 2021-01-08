package leetcode.mid;

import java.util.LinkedList;

/**
 * Description: 字符串解码
 * User: liqing@pluosi
 * Date: 2021-01-05
 * Time: 10:00 PM
 */
public class DecodeString {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]"));
    }

}
