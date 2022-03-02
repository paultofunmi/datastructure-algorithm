package com.solutions;

public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];

        for(int i = m-1; i>=0; i--) {
            for(int j = n-1; j>=0; j--) {

                if(i == m-1 && j == n-1){
                    dp[i][j] = grid[i][j];
                }
                else if(i == m-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }
                else if(j == n-1){
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

//        int[][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println(MinimumPathSum.minPathSum(grid1)); //7

        int[][] grid2 = {{1,2,3},{4,5,6}};
        System.out.println(MinimumPathSum.minPathSum(grid2)); //12
    }
}
