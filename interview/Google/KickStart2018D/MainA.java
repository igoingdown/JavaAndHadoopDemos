package interview.Google.KickStart2018D;

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = 0;
        if (in.hasNext()) T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            long N = in.nextLong(), O = in.nextLong(), D = in.nextLong(),  X1 = in.nextLong(), X2 = in.nextLong(), A = in.nextLong(), B = in.nextLong(), C = in.nextLong(), M = in.nextLong(), L = in.nextLong();
            Long[] Xs = new Long[(int)N];
            Xs[0] = X1;
            Xs[1] = X2;
            for (int j = 2; j < N; j++) {
                Xs[j] = (A * Xs[j - 1] % M + B * Xs[j - 2] % M + C % M) % M;
                Xs[j - 2] += L;
            }
            Xs[(int)N - 1] += L;
            if (N >= 3) Xs[(int)N - 2] += L;
            Long res = null;
            for (int m = 0; m < N; m++) {
                long oddCount = 0, cS = 0;
                for (int n = m; n < N && oddCount <= O ; n++) {
                    oddCount += Xs[n] % 2;
                    if (oddCount > O) continue;
                    cS += Xs[n];
                    if (cS <= D) {
                        if (res == null) res = cS;
                        else res = Math.max(res, cS);
                    }
                }
            }
            if (res == null) System.out.printf("Case #%d:IMPOSSIBLE\n", i);
            else System.out.printf("Case #%d:%d\n", i, res);
        }
    }
}
