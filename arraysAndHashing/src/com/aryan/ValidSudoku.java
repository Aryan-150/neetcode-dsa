package com.aryan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("ALL")
public class ValidSudoku {
  public static void main(String[] args) {

  }

  public static boolean validSudokuBruteForce(char[][] board) {
    // check for the rows:
    for (int row = 0; row < 9; row++) {
      Set<Character> visited = new HashSet<>();
      for (int i = 0; i < 9; i++) {
        char ch = board[row][i];
        if (ch == '.') continue;
        if (visited.contains(ch)) return false;
        visited.add(ch);
      }
    }

    // check for the columns:
    for (int col = 0; col < 9; col++) {
      Set<Character> visited = new HashSet<>();
      for (int i = 0; i < 9; i++) {
        char ch = board[i][col];
        if (ch == '.') continue;
        if (visited.contains(ch)) return false;
        visited.add(ch);
      }
    }

    // check for 3x3 matrices/blocks:
    for (int square = 0; square < 9; square++) {
      Set<Character> visited = new HashSet<>();
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          int row = (square / 3) * 3 + i;
          int col = (square % 3) * 3 + j;
          char ch = board[row][col];
          if (ch == '.') continue;
          if (visited.contains(ch)) return false;
          visited.add(ch);
        }
      }
    }
    return true;
  }

  public static boolean validSudokuBetterOnePass(char[][] board) {
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<String, Set<Character>> squares = new HashMap<>();

    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        char ch = board[row][col];
        if (ch == '.') continue;

        String squareKey = (row / 3) + "," + (col / 3);

        if (rows.computeIfAbsent(row, k -> new HashSet<>()).contains(ch) ||
            cols.computeIfAbsent(col, k -> new HashSet<>()).contains(ch) ||
            squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(ch)
        ) {
          return false;
        }

        rows.get(row).add(ch);
        cols.get(col).add(ch);
        squares.get(squareKey).add(ch);
      }
    }
    return true;
  }



}

/**
 * brute force:
 * ============
 *
 *
 * HasSet (one pass):
 * =================
 *
 *
 *
 */
