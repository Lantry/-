package cn.zliangcheng.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        createParenthesis(result, n, n, "");
        return result;
    }

    private void createParenthesis(List<String> result, int left, int right, String parentheses) {
        if (left == 0 && right == 0) {
            result.add(parentheses);
            return;
        }
        if (left > 0) {
            createParenthesis(result, left - 1, right, parentheses + "(");
        }

        if (right > left) {
            createParenthesis(result, left, right - 1, parentheses + ")");
        }
    }
}
