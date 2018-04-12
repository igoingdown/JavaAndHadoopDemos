package CCI150;

import java.util.Scanner;

public class FindElementInSpiralArray {
    public static void main(String[] args) {
        int[] arr = {13, 15, 19, 1, 3, 6, 8, 10};
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) System.out.println(FindElement(arr, in.nextInt()));
    }

    public static int FindElement(int[] arr, int target) {
        if (arr.length == 0) return -1;
        int low = 0, high = arr.length - 1, mid;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] == target) return mid;
            if (arr[low] < arr[mid]) {  // 左半侧为正常排序
                if (arr[low] <= target && arr[mid] > target) high = mid - 1;  // target落在正常排序的那部分
                else low = mid + 1;
            } else if (arr[mid] < arr[low]){ // 右半侧为正常排序
                if (arr[mid] < target && arr[high] >= target) low = mid + 1; // target落在正常排序的那部分
                else high = mid - 1;
            } else low++;
        }
        return arr[low] == target ? low : -1;
    }
}
