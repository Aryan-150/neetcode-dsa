package com.aryan;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
  public static void main(String[] args) {
    List<String> input = new ArrayList<>();
    input.add("abcd1234ABCD");
    input.add("code");
    input.add("wor#ld");
    Solution1 test1 = new Solution1();
    test1.encode(input);

//    Solution2 test2 = new Solution2();
//    String encoded_string = test2.encode(input);
//    List<String> decoded_strs = test2.decode(encoded_string);
//    System.out.println(decoded_strs);

  }
}

class Solution1 {
  public String encode(List<String> strs) {
    StringBuilder res = new StringBuilder();

    for (String str : strs) {
      res.append(str.length()).append(",");
    }
    res.append("#");
    for (String str : strs) {
      res.append(str);
    }
    return res.toString();
  }

//  TODO:
//  public List<String> decode(String str) {}

}

class Solution2 {
  public String encode(List<String> strs) {
    StringBuilder res = new StringBuilder();
    for (String str : strs) {
      res.append(str.length()).append("#").append(str);
    }
    return res.toString();
  }

  public List<String> decode(String str) {
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
      int j = i;
      while (str.charAt(j) != '#')
        j++;

      int length = Integer.parseInt(str.substring(i, j));
      i = j + 1;
      j = i + length;
      String word = str.substring(i, j);
      res.add(word);
      i = j;
    }
    return res;
  }
}

/**
 * i/p -> ["hello", "wor#d"]
 * solution1:
 * ==========
 * encoded_string -> "45#hellowor#d"
 *
 * solution2:
 * ==========
 * encoded_string -> "4#hello5#wor#d"
 *
 */