package package_1;

import javafx.util.Pair;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by zhaomingxing on 2017/1/8.
 */
public class PairTest2 {
    public static void main(String[] args) {
        GregorianCalendar[] birthDays = {
                new GregorianCalendar(1999, Calendar.APRIL, 12),
                new GregorianCalendar(1990, Calendar.DECEMBER, 20),
                new GregorianCalendar(2006, Calendar.SEPTEMBER, 1),
                new GregorianCalendar(2012, Calendar.JULY, 1)
        };
        Pair<GregorianCalendar, GregorianCalendar> minAndMax = minmax(birthDays);
        System.out.println("min: " + minAndMax.getKey().getTime());
        System.out.println("max: " + minAndMax.getValue().getTime());
    }

    public static <T extends Comparable> Pair<T, T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        } else {
            T min = a[0];
            T max = a[0];
            for (T e: a) {
                if (min.compareTo(e) > 0) {
                    min = e;
                }
                if (max.compareTo(e) < 0) {
                    max = e;
                }
            }
            return new Pair<T, T>(min, max);
        }
    }
}
