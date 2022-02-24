package com.solutions;

import java.util.LinkedList;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean result1 = WordSearch.exist(board, "ABCCED"); // true
        boolean result2 = WordSearch.exist(board, "SEE"); // true
        boolean result3 = WordSearch.exist(board, "ABCB"); //false

        char[][] board2 = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        boolean result4 = WordSearch.exist(board2, "AAB"); //true

        char[][] board3 = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        boolean result5 = WordSearch.exist(board3, "ABCEFSADEESE"); //true
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }

    public static boolean exist(char[][] board, String word) {
        boolean result = false;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {

                LinkedList<String> seen = new LinkedList<>();
                if(board[row][col] == word.charAt(0) && dfs(board, word, 0, row, col, seen)) {
                    return true;
                }
            }
        }

        return result;
    }

    private static boolean dfs(char[][] board, String word, int position, int row, int col, LinkedList<String> seen) {

        //final result;
        if(seen.size() == word.length()) return true;

        boolean rowOutOfBound = row < 0 || row >= board.length;
        boolean colOutOfBound = col < 0 || col >= board[0].length;

        if(rowOutOfBound || colOutOfBound) return false;
        if(board[row][col] != word.charAt(position)) return false;
        if(seen.contains(row + "," + col)) return false;

        position++;
        seen.add(row + "," + col);

        boolean up = dfs(board, word, position, row - 1, col, seen);
        boolean right = dfs(board, word, position, row, col + 1, seen);
        boolean down = dfs(board, word, position, row + 1, col, seen);
        boolean left = dfs(board, word, position, row, col - 1, seen);

        if(up || right || down || left) return true;

        seen.pollLast();
        return false;
    }
}
