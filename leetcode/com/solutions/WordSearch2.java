package com.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordSearch2 {

    public static void main(String[] args) {

        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        char[][] board2 = {{'a','b'},{'c','d'}};

        System.out.println(WordSearch2.findWords(board, new String[]{"oath","pea","eat","rain"}));
        System.out.println(WordSearch2.findWords(board2, new String[]{"abcb"}));
    }

    public static List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        for(String word: words) {

            for(int row = 0; row < board.length; row++) {

                for(int col = 0; col < board[0].length; col++) {

                    if(board[row][col] == word.charAt(0)) {

                        if(dfs(board, word, 0, row, col)) {

                            if(!result.contains(word)) {
                                result.add(word);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static boolean dfs(char[][] board, String word, int start, int row, int col) {

        if(start == word.length()) return true;

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(board[row][col] != word.charAt(start)) return false;

        char temp = board[row][col];
        board[row][col] = '.';

        if(

                dfs(board, word, start + 1, row - 1, col) ||
                        dfs(board, word, start + 1, row, col + 1) ||
                        dfs(board, word, start + 1, row + 1, col) ||
                        dfs(board, word, start + 1, row, col - 1)
        ) {

            board[row][col] = temp;
            return true;
        }

        board[row][col] = temp;
        return false;
    }
}
