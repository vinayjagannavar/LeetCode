import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> output = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return output;
    }

    private void backtrack(int n, int open, int closed, StringBuilder combination) {
        if (open == n && closed == n) {
            output.add(combination.toString());
            return;
        }

        if (open < n) {
            combination.append('(');
            backtrack(n, open + 1, closed, combination);
            combination.deleteCharAt(combination.length() - 1);
        }

        if (closed < open) {
            combination.append(')');
            backtrack(n, open, closed + 1, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
