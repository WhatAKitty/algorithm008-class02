import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author WhatAKitty
 * @date 2020/05/20
 * @since 1.0.0
 **/
public class GenerateParenthese_week04 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        dfs(result, "", 0, 0, n);
        return result;
    }

    private void dfs(List<String> result, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            // 达到限制
            result.add(cur);
            return;
        }

        if (open < max) {
            dfs(result, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            dfs(result, cur + ")", open, close + 1, max);
        }
    }

}
