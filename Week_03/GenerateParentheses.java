import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @author WhatAKitty
 * @date 2020/04/29
 * @since 1.0.0
 **/
public class GenerateParentheses {

    /**
     * 审题：
     * 1. n对小括号，即：有一个'（'，那么必定有一个'）'
     * 2. 有效的括号对，不能出现例如 (() 这种形式的
     * 可能解法：
     * 1. 递归：
     *      左括号数与右括号数一定与括号对数一致；
     *      左括号树与右括号成一对一关系；
     *      构建字符串，最大与2n相同
     */
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>(0);
        }

        List<String> list = new ArrayList<>();
        breaker(list, "", 0, 0, n);
        return list;
    }

    private void breaker(List<String> list, String str, int open, int close, int max) {
        // 终止条件：字符串长度为有效括号对的最大长度
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        // 递归
        if (open < max) {
            breaker(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            breaker(list, str + ")", open, close + 1, max);
        }
    }

}
