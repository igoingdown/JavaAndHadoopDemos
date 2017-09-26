package package_1;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zhaomingxing on 2016/12/25.
 */

public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        Date d = new Date(199, 2, 1);
        System.out.println(new ObjectAnalyzer().toString(d));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            arr.add(i);
        }
        System.out.println(new ObjectAnalyzer().toString(arr));
    }
}
