package com.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class SurroundedRegion {

    public static void main(String[] args) {

          Node temp = new Node(1);
//        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
//        SurroundedRegion.solve2(board);
        char[][] board2 = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        char[][] board21 = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        SurroundedRegion.solve1(board21);
//        System.out.println("");
//        SurroundedRegion.solve2(board2);
    }

    private static void traverse1(char[][] board, int row, int col) {

        if(row >= board.length || row < 0 || col < 0 || col >= board[0].length) return;

        if(board[row][col] == 'O') board[row][col] = 'T';

        if(row > 0 && board[row - 1][col] == 'O') {

            traverse1(board, row - 1, col);
        }

        if(row < board.length - 1 && board[row + 1][col] == 'O') {

            traverse1(board, row + 1, col);
        }

        if(col > 0 && board[row][col - 1] == 'O') {

            traverse1(board, row, col - 1);
        }

        if(col < board[0].length - 1 && board[row][col + 1] == 'O') {

            traverse1(board, row, col + 1);
        }

        return;
    }

    public static void solve1(char[][] board) {

        for(int row = 0; row < board.length; row++) {
            if(board[row][0] == 'O')  traverse1(board, row, 0);
            if(board[row][board[0].length - 1] == 'O') traverse1(board, row, board[0].length - 1);
        }

        for(int col = 0; col < board[0].length; col++) {
            if(board[0][col] == 'O')  traverse1(board, 0, col);
            if(board[board[0].length - 1][col] == 'O') traverse1(board, board[0].length - 1, col);
        }

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col] == 'O') board[row][col] = 'X';
                else if(board[row][col] == 'T') board[row][col] = 'O';
            }
        }

        for(int row = 0; row < board.length; row++) {
            System.out.println(Arrays.toString(board[row]));
        }
    }

    public static void solve2(char[][] board) {
        Set<Integer> seen = new HashSet<>();
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col] == 'O') {
                    traverse2(board, row, col, seen);
                }
            }
            seen.add(row);
        }
        for(int row = 0; row < board.length; row++) {
            System.out.println(Arrays.toString(board[row]));
        }
    }

    private static boolean traverse2(char[][] board, int row, int col, Set<Integer> seen) {

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(board[row][col] == 'X') return true;
        if(seen.contains(row) && board[row][col] == 'O') {
            return false;
        }

        board[row][col] = 'X';

        boolean result = traverse2(board, row - 1, col, seen)
                && traverse2(board, row, col + 1, seen)
                && traverse2(board, row + 1, col, seen)
                && traverse2(board, row, col - 1, seen);

        if(!result) {
            board[row][col] = 'O';
            return false;
        }
//        System.out.println("Seen contains: " + seen);
        return true;
    }
}
