package com.aryan;

import java.util.*;

public class GroupAnagrams {
  static void main() {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> result = groupAnagramsThroughHashTable(strs);
    System.out.println(result);
  }

  static List<List<String>> groupAnagramsBruteForce(String[] strs) {
    List<List<String>> finalResult = new ArrayList<>();
    int[] included = new int[strs.length];

    for (int i = 0; i < strs.length; i++) {
      if (included[i] == 1) continue;
      List<String> output = new ArrayList<>();
      output.add(strs[i]);
      for (int j = i + 1; j < strs.length; j++) {
        if (ValidAnagrams.isAnagramThroughHashTable(strs[i], strs[j])) {
          output.add(strs[j]);
          included[j] = 1;
        }
      }
      finalResult.add(output);
    }

    return finalResult;
  }

  static List<List<String>> groupAnagramsThroughSorting(String[] strs) {
    HashMap<String, List<String>> freq = new HashMap<>();
    for (String str : strs) {
      char[] temp = str.toCharArray();
      Arrays.sort(temp);
      String sortedTemp = new String(temp);
      freq.putIfAbsent(sortedTemp, new ArrayList<>());
      freq.get(sortedTemp).add(str);
    }

    return  new ArrayList<>(freq.values());
  }

  static List<List<String>> groupAnagramsThroughHashTable(String[] strs) {
    Map<String, List<String>> included = new HashMap<>();

    for (String str : strs) {
      int[] count = new int[26];
      for (char ch : str.toCharArray()) {
        count[ch - 'a']++;
      }
      String key = Arrays.toString(count);
      included.putIfAbsent(key, new ArrayList<>());
      included.get(key).add(str);
    }

    return new ArrayList<>(included.values());
  }

}

/**
 * given, m -> length of strs & n -> length of longest string in the strs.
 * brute force:
 * ============
 * T.C: O(m^2 * n)
 * S.C: O(m)
 *
 * better approach: sorting
 * ========================
 * T.C: O(m * n*log(n))
 * S.C:
 *
 * optimal approach: hashtable
 * ===========================
 * T.C: O(m * n)
 * S.C:
 *
 */
