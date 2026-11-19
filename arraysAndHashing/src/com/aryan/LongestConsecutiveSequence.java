package com.aryan;

import java.util.Arrays;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    int[] arr = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
    int result = longestConsecutiveSorting(arr);
    System.out.println(result);
  }

  public static int longestConsecutiveSorting(int[] nums) {
    int n = nums.length;
    // edge case:
    if (n == 0) return 0;

    Arrays.sort(nums);
    int res = 0, cnt = 0;
    for (int i = 1; i < n; i++) {
      int temp = nums[i] - nums[i - 1];
      if (temp == 1) cnt++;
      if (temp > 1) {
        res = Math.max(res, cnt);
        cnt = 0;
      }
    }
    res = Math.max(res, cnt);
    return res + 1;
  }

}
