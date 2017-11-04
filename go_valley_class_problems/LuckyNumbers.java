package go_valley_class_problems;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {
        List<String> aList = luckyNumbers("2224", 888);
        for (String s : aList) System.out.println(s);
    }

    private static List<String> luckyNumbers(String num, int target) {
        List<String> res = new ArrayList<>();
        recursion(num, target, 0, 0, 0, res, "");
        return res;
    }

    private static void recursion(String num, int target, int start, int cur, int last,
                                  List<String> res, String solution) {
        // TODO: 注意last参数的处理。
        // TODO: 注意start为0的情况的处理。
        if (start == num.length()) {
            if (target == cur) res.add(solution);
            return;
        }
        for (int i = start; i < num.length(); i++) {
            String numString = num.substring(start, i + 1);
            if (num.charAt(start) == '0' && i != start) break;
            int numInt = Integer.parseInt(numString);
            if (start == 0) {
                recursion(num, target, i + 1, numInt, numInt, res, solution + numString);
            } else {
                recursion(num, target, i + 1, cur + numInt, numInt, res,solution + '+' + numString);
                recursion(num, target, i + 1, cur - numInt, - numInt, res, solution + '-' + numString);
                recursion(num, target, i +1, cur - last + last * numInt, last * numInt,
                        res, solution + '*' + numString);
                if (numInt > 0 && last % numInt == 0) {
                    recursion(num, target, i + 1, cur - last + last * numInt,
                            last / numInt, res, solution + "/" + numString);
                }
            }
        }
    }
}
