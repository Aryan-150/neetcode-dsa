package com.aryan;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagrams {

  static void main() {
    String s = "cat";
    String t = "rat";

    boolean result = isAnagramThroughHashTable(s, t);
    System.out.println(result);
  }

  static boolean isAnagramThroughSorting(String s, String t) {
    if(s.length() != t.length()){
      return false;
    }
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    Arrays.sort(sChars);
    Arrays.sort(tChars);

    for(int i = 0; i < s.length(); i++){
      if(sChars[i] != tChars[i])
        return false;
    }
    return true;
  }

  static boolean isAnagramThroughHashMap(String s, String t) {
    if (s.length() != t.length())
      return false;

    HashMap<Character, Integer> sCount = new HashMap<>();
    HashMap<Character, Integer> tCount = new HashMap<>();

    for(int i = 0; i < s.length(); i++){
      sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
      tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);

      // if (!sCount.containsKey(s.charAt(i))){
      //     sCount.put(s.charAt(i), 0);
      // }
      // if(!tCount.containsKey(t.charAt(i))){
      //     tCount.put(t.charAt(i), 0);
      // }
      // sCount.put(s.charAt(i), sCount.get(s.charAt(i)) + 1);
      // tCount.put(t.charAt(i), tCount.get(t.charAt(i)) + 1);
    }

    return sCount.equals(tCount);
  }

  static boolean isAnagramThroughHashTable(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] visited = new int[26];
    for(int i = 0; i < s.length(); i++) {
      visited[s.charAt(i) - 'a']++;
      visited[t.charAt(i) - 'a']--;
    }

    for(int val:visited){
      if(val != 0)
        return false;
    }

    return true;
  }

}


/**
 * brute force: when s & t are in lowercase only.
 * ==============================================
 * sFreq[26], tFreq[26];
 * loop(char ch:s):
 *   sFreq[ch - 'a'] += 1;
 *
 * loop(char ch:t):
 *   tFreq[ch - 'a'] += 1;
 *
 * loop(i: 0 -> 25):
 *   if(sFreq[i] != tFreq[i])
 *     return false;
 *
 * return true;
 * T.C: O(s.length) + O(t.length) + o(25)
 * S.C: 2 * O(26)
 *
 * better approach: "sorting" + "traversal"
 * =======================================
 * n = s.length() & m = t.length()
 * T.C: O(n*log(n)) + O(m*log(m)) + O(n)
 * S.C: O(n) + O(m)
 *
 * optimal approach: "HashMaps"
 * ===========================
 * n = s.length() & m = t.length()
 * T.C: O(n + m) ~ O(n)
 * S.C: O(1)
 *
 * optimal approach: "HashTable (using arrays)"
 * ============================================
 * n = s.length() & m = t.length()
 * T.C: O(n + m) ~ O(n)
 * S.C: O(1)
 *
 */