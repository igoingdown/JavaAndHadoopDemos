package interview.Pinduoduo.OnlineRound2;

import java.util.*;

public class Problem2 {

    public static void main(String[] args){
        Problem2 test = new Problem2();
        test.helper();
    }

    public void helper(){
        Scanner in = new Scanner(System.in);
        String number = in.nextLine();
        int count = 0;
        for(int i = 1; i < number.length(); ++i){
            int res1 = dfs(number.substring(0,i));
            int res2 = res1 > 0 ? dfs(number.substring(i)) : 0;
            if(res1 > 0 && res2 > 0){
                count += res1 * res2;
            }
        }
        System.out.print(count);
    }
    private int dfs(String number){
        return checkDecimal(number) + checkInt(number);
    }

    private int checkInt(String s) {
        if (s.length() > 0 && s.charAt(0) == '0') {
            return 0;
        }
        return 1;
    }

    private int checkDecimal(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(s.length() - 1) == '0') {
            return s.length() == 1 ? 1 : 0;
        }
        if (s.charAt(0) == '0') {
            return 1;
        }
        return s.length() - 1;
    }
}
