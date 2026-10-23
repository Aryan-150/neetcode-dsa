package com.aryan;

public class ValidAnagrams {

  static void main() {

  }

  static boolean isAnagram(String s, String t){
    if(s.length() != t.length())
      return false;



    return true;
  }

  static boolean isAnagramOnlyLowerCase(String s, String t) {

    return true;
  }
}


/*
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
*
* better approach: can contain any type of characters.
* =====================================================
* Map<Char, Integer> freq;
* loop(char ch:s):
*   freq.putIfAbsent(ch, 0);
*   freq.value(ch) += 1;
*
* loop(char ch:t):
*   frreq.value(ch) -= 1;
*
* loop(auto it:freq):
*   freq.value(it) != 0 && return false;
*
* return true;
*
* optimal approach:
* =================
*
* */