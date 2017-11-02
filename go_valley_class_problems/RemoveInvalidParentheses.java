package go_valley_class_problems;


import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        removeInvalidParentheses("");
        for (String s: res) {
            System.out.println(s);
        }
    }

    private static List<String> removeInvalidParentheses(String s) {
        dfs(s, "", 0, 0);
        if (res.size() == 0) {
            res.add("");
        }
        return res;
    }

    private static void dfs(String str, String subRes, int left, int tmpMax) {
        if (str.equals("")) {
            if (left == 0 && subRes.length() > 0) {
                if (tmpMax > max) {
                    max = tmpMax;
                    res.clear();
                }
                if (tmpMax == max && !res.contains(subRes)) {
                    res.add(subRes);
                }
            }
            return;
        }
        if (str.charAt(0) == '(') {
            dfs(str.substring(1), subRes.concat("("), left+1, tmpMax + 1);
            dfs(str.substring(1), subRes, left, tmpMax);
        } else if (str.charAt(0) == ')') {
            if (left > 0) {
                dfs(str.substring(1), subRes.concat(")"), left - 1, tmpMax + 1);
            }
            dfs(str.substring(1), subRes, left, tmpMax);
        } else {
            String skipLetter = String.valueOf(str.charAt(0));
            dfs(str.substring(1), subRes.concat(skipLetter), left, tmpMax + 1);
        }
    }
    private static List<String> res = new ArrayList<>();
    private static int max = 0;
}
