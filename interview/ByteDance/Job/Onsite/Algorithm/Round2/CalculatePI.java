package interview.ByteDance.Job.Onsite.Algorithm.Round2;

public class CalculatePI {
    public static void main(String[] args) {
        System.out.println(solve());
    }

    private static double solve() {
        int circleCount = 0, total = 100000000;
        for (int i = 0; i < total; i++) {
            double x = Math.random(), y = Math.random();
            if(x * x + y * y < 1) circleCount += 1;
        }
        return (double) circleCount / total * 4;
    }
}
