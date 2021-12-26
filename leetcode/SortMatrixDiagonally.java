package leetcode;

import java.util.PriorityQueue;

public class SortMatrixDiagonally {

    /**
     * Sorts from top left to bottom right
     * 
     * @param mat
     * @return
     */
    public static int[][] diagonalSort1(int[][] mat) {

        for(int i = mat[0].length - 1; i >= 0; i--){
            
            diagonalSort1(mat, 0, i);
        }

        for(int i = 1; i < mat.length; i++) {

            diagonalSort1(mat, i, 0);
        }

        return mat;
    }

    private static void diagonalSort1(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = r, j = c; i < m && j < n; i++, j++) {

            pq.add(mat[i][j]);
        }

        while(pq.size() > 0) {
            mat[r++][c++] = pq.poll();
        }
    }



    /**
     * Sorts from top right to bottom left
     * 
     * @param mat
     * @return
     */
    public static int[][] diagonalSort2(int[][] mat) {

        for(int i = mat[0].length - 1; i >= 0; i--){
            
            diagonalSort2(mat, 0, i);
        }

        for(int i = 1; i < mat.length; i++) {

            diagonalSort2(mat, i, mat.length - 1);
        }

        return mat;
    }

    private static void diagonalSort2(int[][] mat, int r, int c) {

        int m = mat.length;
        // int n = mat[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = r, j = c; i < m && j >= 0; i++, j--) {

            pq.add(mat[i][j]);
        }

        while(pq.size() > 0) {
            mat[r++][c--] = pq.poll();
        }
    }
    
    public static void main(String[] args) {
        
        int[][] mat =  {
            {3, 3, 1, 5},
            {2,0,1,4},
            {1,6,3,3},
            {2,4,6,8}
        };

        int[][] result = SortMatrixDiagonally.diagonalSort1(mat);

        int[][] mat2 =  {
            {3, 3, 1, 5},
            {2, 0, 1, 4},
            {1, 6, 3, 3},
            {2, 4, 6, 8}
        };

        int[][] result1 = SortMatrixDiagonally.diagonalSort2(mat2);
    }
}
