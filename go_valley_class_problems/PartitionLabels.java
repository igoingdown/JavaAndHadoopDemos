package go_valley_class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        for (Integer i : partitionLabels(s)) {
            System.out.println(i);
        }
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> re = new ArrayList<>();
        if(S.length()==0) return re;
        int[][] pos = new int[26][2];//0代表最左边位置，1代表最右边位置
        for(int i=0; i<26; i++)Arrays.fill(pos[i], -1);
        for(int i=0; i<S.length(); i++){
            int v = S.charAt(i)-'a';
            if(pos[v][0]==-1)pos[v][0]=i;
            else pos[v][1]=Math.max(i, pos[v][1]);
        }
        for(int i=0;i<26;i++)
            pos[i][1]=Math.max(pos[i][0], pos[i][1]);
        //当前指针和结尾指针
        int pre=0,stop=0;
        while(pre<S.length()){
            stop=Math.max(stop, pos[S.charAt(pre)-'a'][1]);
            StringBuffer sb = new StringBuffer();
            while(pre<S.length()&&pre<=stop){
                sb.append(S.charAt(pre));
                stop=Math.max(stop, pos[S.charAt(pre)-'a'][1]);
                pre++;
            }

            re.add(sb.toString().length());
        }
        return re;
    }
}

