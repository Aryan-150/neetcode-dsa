package com.aryan;

import java.util.*;

public class TopKFrequentElements {
  static void main() {
    int[] nums = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
    int k = 2;
    int[] result = topKFrequentThroughPriorityQueue(nums, k);
    for (int num : result) {
      System.out.print(num + " ");
    }
  }

  static int[] topKFrequentBruteForce(int[] nums, int k) {
    HashMap<Integer, Integer> uniqueElements = new HashMap<>(); // space O(m)

    for (int num : nums) {
      uniqueElements.putIfAbsent(num, 0);
      uniqueElements.put(num, uniqueElements.get(num) + 1);
    }

    int[][] freq = new int[uniqueElements.size()][2]; // space O(m)

    int index = 0;
    for (Map.Entry<Integer, Integer> entry : uniqueElements.entrySet()) {
      freq[index][0] = entry.getKey();
      freq[index][1] = entry.getValue();
      index++;
    }
    Arrays.sort(freq, Comparator.comparingInt(a -> -a[1])); // space O(m) worst

    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = freq[i][0];
    }

    return ans;
  }

  static int[] topKFrequentThroughPriorityQueue(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();  // space O(m)
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    // create a priority-queue (value, frequency):
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // space O(m)

    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      queue.offer(new int[]{entry.getKey(), entry.getValue()});
      if (queue.size() > k) {
        queue.poll();
      }
    }

    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      int[] element = queue.poll();

      if (element == null) {
        break;
      }

      ans[i] = element[0];
    }

    return ans;
  }

}

/**
 * i/p -> [1,2,1,2,1,2,3,1,3,2] & k = 2
 * o/p -> [1,2]
 * brute force: hashmap + sorting
 * ===============================
 * T.C: O(n) + O(m) + O(m * log(m)) + O(k) ~ O(n + m*log(m))
 * S.C: O(m) + O(m) + O(m) ~ O(m)
 *
 * better approach: priority queue
 * ===============================
 * T.C: O(n) + O(m * log(k)) + O(k * log(k)) ~ O(n * log(k))
 * S.C: O(m) + O(k) ~ O(m + k) ~ O(m)
 */
