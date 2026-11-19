package com.aryan;

public class ValidPalindrome {
  public static void main(String[] args) {
    String inputStr = "Was it a car or a cat I saw?";
    boolean result = isPalindrome(inputStr);
    System.out.println(result);
  }

  public static boolean isAlphaNumeric(char ch) {
    return (ch >= 'a' && ch <= 'z') ||
            (ch >= 'A' && ch <= 'Z') ||
            (ch >= '0' && ch <= '9');
  }

  public static boolean isPalindrome(String s) {
    int n = s.length();
    s = s.toLowerCase();

    StringBuilder str = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (isAlphaNumeric(s.charAt(i))) {
        str.append(s.charAt(i));
      }
    }

    int start = 0, end = str.length() - 1;
    while (start < end) {
      if (str.charAt(start) != str.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }
}
