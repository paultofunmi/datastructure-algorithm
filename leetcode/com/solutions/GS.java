package com.solutions;

import java.io.*;
import java.util.*;

/* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{1,1,1,1,5}, New_York (finish)           N
 **                  {1,0,0,0,0},                         < W   E >
 **   So_Cal (start) {2,0,0,15,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */
public class GS {
    /*
     **  Find the optimal path.
     */
    public static Integer optimalPath(Integer[][] grid)
    {
        Integer[][] temp = new Integer[grid.length][grid[0].length];
        int rowSize = grid.length;

        for(int row = grid.length - 1;  row >= 0; row--) {

            for(int col = 0; col < grid[0].length; col++) {

                if(row == rowSize - 1 && col - 1 < 0) { //fill initial position
                    temp[row][col] = grid[row][col];
                }else if(row == rowSize - 1) { //fill the rows
                    temp[row][col] = temp[row][col - 1] + grid[row][col];
                }else if(col == 0 && row + 1 < rowSize) { //fill the cols
                    temp[row][col] = temp[row + 1][col] + grid[row][col];
                } else { //fill other positions
                    temp[row][col] = Math.max(
                            temp[row + 1][col] + grid[row][col],
                            temp[row][col - 1] + grid[row][col]
                    );
                }
            }
        }
        return temp[0][temp[0].length - 1];
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        boolean result1 = true;
        boolean result2 = true;
        // Base test case
        result1 &= optimalPath(new Integer[][]{{0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}}) == 10;

        result2 &= optimalPath(new Integer[][]{{1,1,1,1,5},
                {1,0,0,0,0},
                {2,0,0,15,0}}) == 23;

        return result1 & result2;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}

