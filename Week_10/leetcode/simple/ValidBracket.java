package leetcode.simple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 有效的括号
 * User: liqing@pluosi
 * Date: 2021-01-04
 * Time: 10:45 PM
 * <p>
 * 1.遇到左括号的时候入栈
 * 2.遇到右括号的时候弹出，同时判断栈顶的元素是不是左括号
 * 3.最后如果栈为空，则说明字符串合法
 */
public class ValidBracket {

    public boolean isValid(String s) {

        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>(3) {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new ArrayDeque();

        for (char ch : s.toCharArray()) {
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !pairs.get(ch).equals(stack.peek())) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }
}
