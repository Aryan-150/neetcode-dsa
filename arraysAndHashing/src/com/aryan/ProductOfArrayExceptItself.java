package com.aryan;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
  public static void main(String[] args) {
    int[] input = {2, 8, 1, 6};
    int[] result = productExceptSelfPrefixSuffixOptimal(input);
    System.out.println(Arrays.toString(result));
  }

  public static int[] productExceptSelfBruteForce(int[] nums) {
    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int prod = 1;
      for (int j = 0; j < nums.length; j++) {
        if (i == j) continue;
        prod *= nums[j];
      }
      ans[i] = prod;
    }
    return ans;
  }

  public static int[] productExceptSelfPrefixSuffixBetter(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    int[] prefix = new int[n];
    int[] suffix = new int[n];

    prefix[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    suffix[n - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < nums.length; i++) {
      ans[i] = prefix[i] * suffix[i];
    }
    return ans;
  }

  public static int[] productExceptSelfPrefixSuffixOptimal(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    int prefix = 1;
    for (int i = 0; i <= n-1; i++) {
      res[i] = prefix;
      prefix *= nums[i];
    }

    int suffix = 1;
    for (int i = n-1; i >= 0; i--) {
      res[i] *= suffix;
      suffix *= nums[i];
    }

    return res;
  }

}

/**
 * brute force:
 * ============
 *
 *
 * better approach:
 * ================
 *
 * optimal approach:
 * =================
 *
 */