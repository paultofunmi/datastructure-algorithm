package com.solutions;

public class Search2DMatrix2 {

    public static void main(String[] args) {

        int[][] matrix1 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(Search2DMatrix2.bruteForce(matrix1, 5)); //true
        System.out.println(Search2DMatrix2.bruteForce(matrix1, 20)); //false
        System.out.println(Search2DMatrix2.searchMatrixBFS(matrix1, 5)); //true
        System.out.println(Search2DMatrix2.searchMatrixBFS(matrix1, 20)); //false
    }

    private static boolean bruteForce(int[][] matrix, int target) {

        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix[0].length; j++) {

                if(matrix[i][j] == target) return true;
            }
        }

        return false;
    }

    public static boolean searchMatrixBFS(int[][] matrix, int target) {

        for(int row = 0; row < matrix.length; row++) {

            for(int col = 0; col < matrix[row].length; col++) {

                boolean result = traverse(matrix, row, col, target);
                if(result) return true;
            }
        }

        return false;
    }

    private static boolean traverse(int[][] matrix, int row, int col, int target) {

        boolean rowOutOfBound = row < 0 || row >= matrix.length;
        boolean colOutOfBound = col < 0 || col >= matrix[0].length;

        if(rowOutOfBound || colOutOfBound) return false;

        if(matrix[row][col] == 0) return false;

        if(matrix[row][col] == target) {

            return true;
        }

        matrix[row][col] = 0;

        if(
                        traverse(matrix, row - 1, col, target) ||
                        traverse(matrix, row, col + 1, target) ||
                        traverse(matrix, row + 1, col, target) ||
                        traverse(matrix, row, col - 1, target)
        ) {

            return true;
        }

        return false;
    }
}
