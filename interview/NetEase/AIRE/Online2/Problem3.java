package interview.NetEase.AIRE.Online2;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(in.nextLine());
            HashMap<Integer, TreeSet<TimeRange>> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                String[] weekdayTimesRanges = in.nextLine().split(" ");
                int weekday = Integer.parseInt(weekdayTimesRanges[0]);
                int times = Integer.parseInt(weekdayTimesRanges[1]);
                for (int l = 0; l < times; l++) {
                    String[] startEnd = weekdayTimesRanges[2 + l].split("-");
                    String[] start = startEnd[0].split(":");
                    int startH = Integer.parseInt(start[0]), startM = Integer.parseInt(start[1]), startS = Integer.parseInt(start[2]);
                    String[] end = startEnd[1].split(":");
                    int endH = Integer.parseInt(end[0]), endM = Integer.parseInt(end[1]), endS = Integer.parseInt(end[2]);
                    TimeRange range = new TimeRange(new HMS(startH, startM, startS), new HMS(endH, endM, endS));
                    if (!map.containsKey(weekday)) {
                        map.put(weekday, new TreeSet<>(new OpenTimeComparator()));
                    }
                    map.get(weekday).add(range);
                }
            }
            int c = Integer.parseInt(in.nextLine());
            for (int j = 0; j < c; j++) {
                String[] weekdayTime = in.nextLine().split(" ");
                int weekday = Integer.parseInt(weekdayTime[0]);
                String[] curHMS = weekdayTime[1].split(":");
                int curH = Integer.parseInt(curHMS[0]), curM = Integer.parseInt(curHMS[1]), curS = Integer.parseInt(curHMS[2]);
                HMS curTime = new HMS(curH, curM,curS);
                boolean flag = false;
                if (map.containsKey(weekday)) {
                    for (TimeRange range : map.get(weekday)) {
                        if (range.start.compareTo(curTime) <= 0 && range.end.compareTo(curTime) >= 0)
                        {
                            System.out.println(0);
                            flag = true;
                            break;
                        }
                        if (range.start.compareTo(curTime) > 0) {
                            System.out.println(range.start.compareTo(curTime));
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    for (int bias = 1; bias <= 7; bias++) {
                        int candidate = (weekday + bias) % 7;
                        if (candidate == 0) candidate = 7;
                        if (map.containsKey(candidate)) {
                            System.out.println(bias * 3600 * 24 + map.get(candidate).first().start.compareTo(curTime));
                            break;
                        }
                    }
                }
            }
        }

    }
    public static class OpenTimeComparator implements Comparator<TimeRange> {
        @Override
        public int compare(TimeRange o1, TimeRange o2) {
            return o1.start.compareTo(o2.start);
        }
    }



    public static class HMS {
        public int hour;
        public int minute;
        public int second;
        public HMS(int h, int m, int s) {
            hour = h;
            minute = m;
            second = s;
        }
        public int compareTo(HMS o) {
            return toSecond() - o.toSecond();
        }

        public int toSecond() {
            return hour * 3600 + minute * 60 + second;
        }
    }

    public static class TimeRange{
        public HMS start;
        public HMS end;
        public TimeRange(HMS s, HMS e) {
            start = s;
            end = e;
        }
    }
}
