package com.solutions;

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = (matrix.length * matrix[0].length) - 1;

        while(left <= right) {

            int mid = (left + right) / 2;
            int row =  mid / matrix.length;
            int col = mid % matrix.length;

            if(matrix[row][col] < target) {
                left = mid + 1;
            }else if (matrix[row][col] > target) {
                right = mid - 1;
            }else {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(Search2DMatrix.searchMatrix(matrix, 13));
    }
}
