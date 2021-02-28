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
        /**
         * 0.初始化
         * 1） 构造一个StringBuilder res 用来连接最开始出现的字母，并构造最后输出的结果
         * 2）初始化数字 multi = 0
         */
        StringBuilder res = new StringBuilder();
        int multi = 0;

        /**
         * 1.构造2个辅助栈：
         * 1) 存放表示重复次数的数字 stack_multi
         * 2）存放被括号包围的重复字符串 stack_res
         */
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();

        /**
         * 2.遍历字符串的所有字符
         * 1）如果当前字符为字母，则用res进行连接，待处理
         * 2）如果当前字符为数字，则 multi = multi * 10 + Integer.parseInt(c + "")
         * 3）如果当前字符为'[',则开始进行进栈处理，表示开始进行递归，结束后对变量multi和res进行初始化
         * 4）如果当前字符为']',则开始进行出栈处理，先对res进行重复连接，然后拼接上res栈里最近的一个元素
         */
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                res.append(ch);
            } else if (ch > '0' && ch <= '9') {
                multi = multi * 10 + Integer.parseInt(ch + "");
            } else if (ch == '['){
                stack_res.push(res.toString());
                stack_multi.push(multi);
                multi = 0;
                res = new StringBuilder();
            }else if(ch == ']'){
                int cur_multi = stack_multi.pop();
                StringBuffer tmp = new StringBuffer();
                for(int i=0;i<cur_multi;i++){
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop()+tmp);
            }
        }

        /**
         * 3.最后返回res.toString()
         */
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]"));
    }

}
