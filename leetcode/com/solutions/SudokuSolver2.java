package com.solutions;

public class SudokuSolver2 {

    private static boolean isNumberInRow(char[][] board, char ch, int row) {

        for(int i = 0; i < board.length; i++) {

            if(board[row][i] == ch) return true;
        }

        return false;
    }

    private static boolean isNumberInCol(char[][] board, char ch, int col) {

        for(int i = 0; i < board.length; i++) {

            if(board[i][col] == ch) return true;
        }

        return false;
    }

    private static boolean isNumberInBoard(char[][] board, char ch, int row, int col) {

        int localBoxRow = row - (row % 3);
        int localBoxCol = col - (col % 3);

        for(int i = localBoxRow; i < localBoxRow + 3; i++) {

            for(int j = localBoxCol; j < localBoxCol + 3; j++) {

                if(board[i][j] == ch) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isValidPlacement(char[][] board, char ch, int row, int col) {

        return !isNumberInRow(board, ch, row) &&
                !isNumberInCol(board, ch, col) &&
                !isNumberInBoard(board, ch, row, col);
    }

    private static boolean solveBoard(char[][] board) {

        for(int row = 0; row < board.length; row++) {

            for(int col = 0; col < board[0].length; col++) {

                if(board[row][col] == '.') {

                    for(int numberToTry = 1; numberToTry<= board.length; numberToTry++) {

                        char charToTry = String.valueOf(numberToTry).charAt(0);

                        if(isValidPlacement(board, charToTry, row, col)) {

                            board[row][col] = charToTry;

                            if(solveBoard(board)) {
                                return true;
                            }else {
//                                System.out.println("returned false at row " + row + " col " + col);
                                board[row][col] = ".".charAt(0);
                            }
                        }
                    }
//                    System.out.println("Found no valid entry for row " + row + " col " + col);
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(char[][] boards) {

        for(int row = 0; row < boards.length; row++) {

            for(int col = 0; col < boards[0].length; col++) {

                System.out.print(boards[row][col]);

                if( (col + 1) % 3 == 0) {
                    System.out.print("|");
                }
            }

            System.out.println("");
            if( (row + 1) % 3 == 0) {
                System.out.println("------------");
            }
        }
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

        System.out.println("Board before solving");
        printBoard(charArray);
        boolean result = SudokuSolver2.solveBoard(charArray);
        if(result) {
            System.out.println("solved");
        }

        System.out.println("Board after solving");
        printBoard(charArray);

//        int n = 1;
//        char nChar = String.valueOf(n).charAt(0);
//        System.out.println(Character.valueOf(nChar));
    }
}
