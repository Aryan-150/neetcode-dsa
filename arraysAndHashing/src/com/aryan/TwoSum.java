package com.aryan;

import java.util.*;

public class TwoSum {
  static void helperDisplay(int[][] arr) {
    for (int[] ints : arr) {
      for (int anInt : ints) {
        System.out.print(anInt + " ");
      }
      System.out.println();
    }
  }

  static void main() {
    Scanner sc = new Scanner(System.in);
    int target = sc.nextInt();
    int[] result = twoSuThroughHashMap(new int[]{15, 7, 2, 11}, target);
    for(int i:result){
      System.out.print(i + " ");
    }
  }

  static int[] twoSumBruteForce(int[] nums, int target) {
    int[] ans = new int[2];

    for(int i = 0; i < nums.length; i++) {
      for(int j = i + 1; j < nums.length; j++) {
        if(nums[i] + nums[j] == target){
          ans[0] = i;
          ans[1] = j;
          break;
        }
      }
    }

    return ans;
  }

  static int[] twoSumThroughSorting(int[] nums, int target) {
    int[][] A = new int[nums.length][2];

    for (int i = 0; i < nums.length; i++) {
      A[i][0] = nums[i];
      A[i][1] = i;
    }
    helperDisplay(A);

    Arrays.sort(A, Comparator.comparingInt((a) -> a[0]));
    helperDisplay(A);

    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      int curr = A[i][0] + A[j][0];
      if(curr == target) {
        return new int[]{
                Math.min(A[i][1], A[j][1]),
                Math.max(A[i][1], A[j][1]),
        };
      }
      else if (curr < target) i++;
      else j--;
    }

    return new int[0];
  }

  static int[] twoSuThroughHashMap(int[] nums, int target) {
    HashMap<Integer, Integer> visited = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int difference = target - nums[i];
      if (visited.containsKey(difference)) {
        return new int[]{
                visited.get(difference),
                i
        };
      }
      visited.put(nums[i], i);
    }

    return new int[0];
  }

}

/**
 * i/p -> nums[], target
 * o/p -> if (nums[i] + nums[j]) == target, then return [i,j];
 *
 * brute force:
 * ============
 * T.C: O(n^2)
 * S.C: O(1)
 *
 * better approach: (sorting + two pointers)
 * =========================================
 * Note: we have to return based on the prev array indexing, not the sorted array indexing.
 * T.C: O(n*log(n)) + O(n) ~ O(n*log(n))
 * S.C: O(n)
 *
 * optimal approach: HashMap in single pass
 * ========================================
 * T.C: O(n)
 * S.C: O(n)
 *
 */