package leetcode.mid;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 241.为运算表达式设计优先级
 * User: liqing@pluosi
 * Date: 2021-02-16
 * Time: 9:59 PM
 */
public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        //这里要注意，每一个调用递归函数都会有一个【属于】本次
        // 调用的res列表存放数据
        // 递归函数传参传进来的是上一层左半部分或者右半部分
        //一层（一次函数调用中）需要将传入数字符串遍历完
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp == '+' || temp == '-' || temp == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (temp == '-') {
                            res.add(l - r);//而一层中只有一个res用于存放数据
                        } else if (temp == '+') {
                            res.add(l + r);
                        } else if (temp == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        //这种情况是只有一个数字字符传入了递归函数，那么该次调用直接返回该数值的list集合
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
            return res;
        }
        return res;
    }
}
