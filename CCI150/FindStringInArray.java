package CCI150;

import java.util.Scanner;

public class FindStringInArray {
    public static void main(String[] args) {
        String[] strs = {"at", "", "", "ball", "", "car", "", "", "", "dad", ""};
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println(indexOfString(strs, str));
            System.out.println(indexOfStringMine(strs, str));
        }
    }

    public static int indexOfString(String[] arr, String target) {
        if (arr.length == 0) return -1;
        int low = 0, high = arr.length - 1, mid;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid].equals(target)) return mid;
            if (arr[mid].length() == 0) {
                int left = mid - 1, right = mid + 1;
                while (true) {
                    if (left < low && right > high) return -1;
                    if (left >= low && !arr[left].isEmpty()) {
                        mid = left; break;
                    }
                    if (right <= high && !arr[right].isEmpty()) {
                        mid = right; break;
                    }
                    --left; ++right;
                }
            }
            int compareRes = arr[mid].compareTo(target);
            if (compareRes == 0) return mid;
            else if (compareRes > 0) high = mid - 1;
            else low = mid + 1;
        }
        return arr[low].equals(target) ? low : -1;
    }

    public static int indexOfStringMine(String[] arr, String target) {
        if (arr.length == 0) return -1;
        int low = 0, high = arr.length - 1, mid;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (arr[low].equals(target)) return low;
            if (arr[high].equals(target)) return high;
            if (arr[mid].equals(target)) return mid;
            if (arr[mid].isEmpty()) {
                ++low; --high;
            } else {
                if (arr[mid].compareTo(target) > 0) high = mid - 1;
                else low = mid + 1;
            }
        }
        return arr[low].equals(target) ? low : -1;
    }
}
