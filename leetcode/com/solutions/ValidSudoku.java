package com.solutions;

import java.util.*;

public class ValidSudoku {

    public static boolean validate(char[][] board) {

        Map<Integer, List<Character>> rows = new HashMap<>();
        Map<Integer, List<Character>> cols = new HashMap<>();
        ArrayList<Character>[][] boards = new ArrayList[3][3];

        for(int row = 0; row < boards.length; row++) {
            for(int col = 0; col < boards[row].length; col++) {
                boards[row][col] = new ArrayList<>();
            }
        }

        for(int row = 0; row < board.length; row++) {

            for(int col = 0; col < board[0].length; col++) {

                if(board[row][col] == '.') continue;

                if(rows.containsKey(row) && rows.get(row).contains(board[row][col])) return false;

                if(cols.containsKey(col) && cols.get(col).contains(board[row][col])) return false;

                int tempRow = row / 3;
                int tempCol = col / 3;

                if(boards[tempRow][tempCol] != null && boards[tempRow][tempCol].contains(board[row][col])) return false;

                if(rows.containsKey(row)) {

                    rows.get(row).add(board[row][col]);
                }else {

                    rows.put(row, new ArrayList<>(Arrays.asList(board[row][col])));
                }

                if(cols.containsKey(col)) {

                    cols.get(col).add(board[row][col]);
                }else {

                    cols.put(col, new ArrayList<>(Arrays.asList(board[row][col])));
                }

                boards[tempRow][tempCol].add(board[row][col]);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] charArray = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(ValidSudoku.validate(charArray));

        char[][] charArray2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(ValidSudoku.validate(charArray2));
    }
}
