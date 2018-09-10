package interview.Google.KickStart.E2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem2 {
    public class Node {
            public char[] ans = new char[N];
            public int cost, pos;
            public void rever(int i){
            if(ans[i]=='1') ans[i]='0';
            else ans[i]='1';
        }
    }

    private static final int N=205;
    private static int n,m,p;
    private static int[] c = new int[N], idcnt = new int[N], mapid = new int[N];
    private static char[][] s = new char[N][N], f = new char[N][N];
    private static char[] ac = new char[N];
    private static Node[] cc = new Node[N*N], ccp = new Node[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int ca = 1; ca <= t; ca++)
        {
            System.out.println(ca);
            solve(in);
        }
    }

    private static boolean check(char[] a){
        for (int i = 1; i <= m; i++) {
            boolean flag=true;
            for (int j = 1; j <= p; j++) {
                if(a[j]!=f[i][j])
                    break;
                if(j==p) flag=false;
            }
            if(!flag)
                return false;
        }
        return true;
    }

    private static void rep(char[][] arr, int start, int end, Scanner in) {
        for (int i = start; i <= end; i++) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(" ");
            buffer.append(in.nextLine());
            arr[i] = buffer.toString().toCharArray();
        }
    }

    private static void solve(Scanner in){
        n = in.nextInt();
        m = in.nextInt();
        p = in.nextInt();
        in.nextLine();
        rep(s, 1, n, in);
        int ans=0;
        for (int i = 1; i <= p; i++) {
            c[i]=0;

            for (int j = 1; j <= n; j++) if(s[j][i]=='1') ++c[i];
            if (c[i] > n-c[i]){
                ans+=n-c[i];
                c[i]=c[i]-(n-c[i]);
                ac[i]='1';
            }
            else{
                ans+=c[i];
                c[i]=(n-c[i])-c[i];
                ac[i]='0';
            }
        }
        for (int i = 1; i <= p; i++) {
            cc[i].ans = ac;
            cc[i].cost=ans+c[i];
            cc[i].pos=i;
            cc[i].rever(i);
        }
        if(check(ac)){
            System.out.println(ans);
            return;
        }
        for (int i = 1; i <= p; i++) ccp[i]=cc[i];
        Arrays.sort(ccp, 1, p + 1, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int i = 1; i <= p; i++) {
            idcnt[i]=ccp[i].pos;
            mapid[ccp[i].pos]=i;
        }

        int maxcnt=p, ccpcnt=p;
        for (int i = 1; i <= 100; i++) {
            if(check(ccp[1].ans)){
                System.out.println(ccp[1].cost);
                return;
            }
            int mapi = mapid[ccp[1].pos];
            for (int j = mapi + 1; j <= p; j++) {
                int idi = idcnt[j];
                cc[++maxcnt].ans = ccp[1].ans;
                cc[maxcnt].rever(idi);
                cc[maxcnt].cost=ccp[1].cost+c[idi];
                cc[maxcnt].pos=idi;
                ccp[++ccpcnt]=cc[maxcnt];
            }
            for (int j = 2; j <= ccpcnt; j++) ccp[j-1]=ccp[j];
            ccpcnt--;
            Arrays.sort(ccp, 1, ccpcnt + 1, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.cost - o2.cost;
                }
            });
            if(ccpcnt>100) ccpcnt=100;
        }
        System.out.println("error!");
    }

}


