package interview.VMware.Job.Online;

import java.util.*;

public class Problem2 {
    // AC 45%
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if (n == 0) System.out.println(0);
        else {
            int[] nums = new int[n], copy = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
                copy[i] = nums[i];
            }
            System.out.println(Math.min(mergeSort(nums, 0, n - 1), downMergeSort(nums, 0, n - 1)));
        }
    }

    private static int downMergeSort(int[] nums, int l, int r) {
        int ans = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            ans += mergeSort(nums, l, mid);
            ans += mergeSort(nums,mid + 1, r);
            ans += downMerge(nums, l, mid, r);
        }
        return ans;
    }

    private static int mergeSort(int[] nums, int l, int r) {
        int ans = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            ans += mergeSort(nums, l, mid);
            ans += mergeSort(nums,mid + 1, r);
            ans += merge(nums, l, mid, r);
        }
        return ans;
    }


    private static int downMerge(int[] nums, int l, int m, int r) {
        int ans = 0, i = l, j = m + 1, ii = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= m && j <= r) {
            if (nums[i] < nums[j]) {
                ans += r - j + 1;
                tmp[ii++] = nums[i++];
            } else {
                tmp[ii++] = nums[j++];
            }
        }
        while (i <= m) tmp[ii++] = nums[i++];
        while (j <= r) tmp[ii++] = nums[j++];
        for (int k = l; k <=r; k++)  {
            nums[k] = tmp[k - l];
        }
        return ans;
    }

    private static int merge(int[] nums, int l, int m, int r) {
        int ans = 0, i = l, j = m + 1, ii = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= m && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[ii++] = nums[i++];
            } else {
                tmp[ii++] = nums[j++];
                ans += m - i + 1;
            }
        }
        while (i <= m) tmp[ii++] = nums[i++];
        while (j <= r) tmp[ii++] = nums[j++];
        for (int k = l; k <=r; k++)  {
            nums[k] = tmp[k - l];
        }
        return ans;
    }
}
