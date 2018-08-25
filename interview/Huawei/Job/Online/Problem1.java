package interview.Huawei.Job.Online;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] numAndPerPrice = str.split("[^0-9.]");
            int num = Integer.parseInt(numAndPerPrice[0]);
            double perPrice = Double.parseDouble(numAndPerPrice[2]);
            double price1 = num * perPrice * (num >= 3 ? 0.7 : 1.0);
            price1 += 10;
            price1 -= price1 >= 50 ? 10 : 0;
            price1 = (int)((price1 * 100) + 0.5) / 100.0;
            double price2 = perPrice * num;
            price2 *= price2 >= 10 ? 0.8 : 1;
            price2 += 6;
            price2 -= price2 >= 99 ? 6 : 0;
            price2 = (int)((price2 * 100) + 0.5) / 100.0;
            System.out.println(Math.abs(price1 - price2) < 1e-10 ? 0 : (price1 < price2 ? 1 : 2));
        }
    }
}
