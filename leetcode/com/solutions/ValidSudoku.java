package com.solutions;

import java.util.*;

// Loop through each row and col
// for each row and col value, check if the new value exists in row or col or board.
// If it exists, return false
// if it doesn't (proceed) add to the row, col or board
// repeat for cols and board.
// if cell is unfilled skip
public class ValidSudoku {

    public static boolean validate1(char[][] board) {

        Map<Integer, List<Character>> rows = new HashMap<>();
        Map<Integer, List<Character>> cols = new HashMap<>();
        List<Character>[][] boards = new ArrayList[3][3];

        for(int row = 0; row < boards.length; row++) {
            for(int col = 0; col < boards[row].length; col++) {
                boards[row][col] = new ArrayList<>();
            }
        }

        for(int row = 0; row < board.length; row++) {

            for(int col = 0; col < board[0].length; col++) {

                if (board[row][col] == '.') continue;

                if (rows.containsKey(row) && rows.get(row).contains(board[row][col])) {
                    return false;
                }

                if(cols.containsKey(col) && cols.get(col).contains(board[row][col])) {

                    return false;
                }

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

    public static boolean validate2(char[][] board) {

        for(int row = 0; row < board.length; row++) {

            for(int col = 0; col < board[0].length; col++) {

                if(board[row][col] == '.') continue;

                if(!isRowValid(board, row, col)) return false;
                if(!isColValid(board, row, col)) return false;
                if(!isGridValid(board, row, col)) return false;
            }
        }

        return true;
    }

    private static boolean isRowValid(char[][] board, int row, int col) {

        for(int col1 = 0; col1 < board.length; col1++ ) {

            if(col1 == col) continue;
            if(board[row][col1] == board[row][col]) return false;
        }
        return true;
    }

    private static boolean isColValid(char[][] board, int row, int col) {

        for(int row1 = 0; row1 < board.length; row1++ ) {

            if(row1 == row) continue;
            if(board[row1][col] == board[row][col]) return false;
        }
        return true;
    }

    private static boolean isGridValid(char[][] board, int row, int col) {

        int rowStart = row - (row % 3);
        int colStart = col - (col % 3);

        for(int row1 = rowStart; row1 < rowStart + 3; row1++) {

            for(int col1 = colStart; col1 < colStart + 3; col1++) {

                if(row == row1 && col == col1) continue;
                if(board[row1][col1] == board[row][col]) return false;
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

        char[][] board = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };

        System.out.println(ValidSudoku.validate1(charArray));
        System.out.println(ValidSudoku.validate1(charArray2));
        System.out.println(ValidSudoku.validate1(board));

        //Validate using second option
        System.out.println("Validating using second approach");
        System.out.println(ValidSudoku.validate2(charArray));
        System.out.println(ValidSudoku.validate2(charArray2));
        System.out.println(ValidSudoku.validate2(board));
    }
}
