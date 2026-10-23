package com.aryan;

import com.sun.source.doctree.SeeTree;

import java.util.HashSet;

public class ContainsDuplicate {
  static void main() {
    boolean result = hasDuplicate(new int[]{1, 2, 3, 3, 5});
    System.out.println(result);
  }

  static boolean hasDuplicate(int[] nums) {
    HashSet<Integer> visited = new HashSet<>();
    for (int num : nums) {
      if (visited.contains(num)) {
        return true;
      }
      visited.add(num);
    }
    return false;
  }
}
/*
* brute force:
* ============
* O(n^2) -> nested loop
*
* better approach-1:
* ==================
* O(n * logn) + O(n) ==> sorting + for-loop
*
* better approach-2:
* ==================
* O(n) + O(m), m = size of the hashmap
* worst case: 2 * O(n) ~ O(n)
*
* optimal approach:
* =================
 * visited<int, boolean>
 * loop(i: 0 -> n-1):
 *  if (visited[nums[i]] == true):
 *    return true;
 *  visited[nums[i]] = true;
 *
 * return false;
 *
* */