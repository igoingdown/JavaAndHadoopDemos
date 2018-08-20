package interview.Pinduoduo.OnlineRound2;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

    private static ArrayList<char[]> solve(char[] in){
        ArrayList<char[]> result = new ArrayList<>();
        int size  = in.length;
        int k = size/4;
        char[] first = new char[k+1];
        char[] last = new char[k+1];
        for(int i = 0; i <= k;i++){
            first[i] = in[i];
            last[i] = in[3*k-i];
        }
        result.add(first);
        for(int i = 0;i <= k-2;i++){
            char[] mid = new char[k+1];
            for(int j = 0;j <=k;j++){
                if(j == 0){
                    mid[j] = in[4*k-i-1];
                }
                else if(j == k){
                    mid[j] = in[k+1+i];
                }
                else{
                    mid[j] = ' ';
                }
            }
            result.add(mid);
        }
        result.add(last);
        return result;
    }

    public static void main(String[] args) {
        Problem1 pin = new Problem1();
        Scanner in = new Scanner(System.in);
        String input=in.nextLine();
        char x[]=input.toCharArray();
        ArrayList<char[]> result = pin.solve(x);
        for(int i = 0;i < result.size();i++){
            System.out.println(result.get(i));
        }
    }
}

