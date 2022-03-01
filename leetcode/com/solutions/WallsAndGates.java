package com.solutions;

/**
 * You are given a m x n 2D grid initialized with these three possible values:
 *  1) -1, a wall or an obstacle
 *  2) 0, a gate
 *  3) INF - infinity means an empty room
 *
 *  Fill each empty room with the distance to its nearest gate, if it is impossible to reach a gate, it should be filled with INF
 *
 *  INF -1   0   INF
 *  INF INF INF  -1
 *  INF -1  INF  -1
 *  0   -1  INF  INF
 *
 *  after running 2D grid should be
 *  3 -1 0 1
 *  2 2 1 -1
 *  1 -1 2 -1
 *  0 -1 3 4
 */
public class WallsAndGates {

    public static void perform(int[][] gates) {

        for(int row = 0 ; row < gates.length; row++) {

            for(int col = 0; col < gates[0].length; col++) {

                if(gates[row][col] == 0) {

                    doDfs(gates, row, col, 0);
                }
            }
        }
    }

    private static void doDfs(int[][] gates, int row , int col, int position) {

        if(row < 0 || row >= gates.length || col < 0 || col >= gates[0].length || gates[row][col] < position) return;

        gates[row][col] = position;

        doDfs(gates, row - 1, col, position + 1);
        doDfs(gates, row, col + 1, position + 1);
        doDfs(gates, row + 1, col, position + 1);
        doDfs(gates, row, col - 1, position + 1);
    }

    public static void printGates(int[][] gates) {

        for(int row =0 ; row < gates.length; row++) {

            for(int col = 0; col < gates[0].length; col++) {

                System.out.print(gates[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] gates = {
                { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
                { Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 },
                { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE }
        };

        WallsAndGates.perform(gates);
        WallsAndGates.printGates(gates);
    }
}
