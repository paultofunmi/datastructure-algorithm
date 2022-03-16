package com.solutions;

import java.io.*;
import java.util.*;

public class GSIV {

    /* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

    /*
     **  Instructions:
     **
     **  Given a list of student test scores, find the best average grade.
     **  Each student may have more than one test score in the list.
     **
     **  Complete the bestAverageGrade function in the editor below.
     **  It has one parameter, scores, which is an array of student test scores.
     **  Each element in the array is a two-element array of the form [student name, test score]
     **  e.g. [ "Bobby", "87" ].
     **  Test scores may be positive or negative integers.
     **
     **  If you end up with an average grade that is not an integer, you should
     **  use a floor function to return the largest integer less than or equal to the average.
     **  Return 0 for an empty input.
     **
     **  Example:
     **
     **  Input:
     **  [ [ "Bobby", "87" ],
     **    [ "Charles", "100" ],
     **    [ "Eric", "64" ],
     **    [ "Charles", "22" ] ].
     **
     **  Expected output: 87
     **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
     **  respectively. 87 is the highest.
     */

    /*
     **  Find the best average grade.
     */
    public static Integer bestAverageGrade(String[][] scores)
    {
            Map<String, List<Integer>> map = new HashMap<>();
            double result = Double.MIN_VALUE;

            for(int row = 0; row < scores.length; row++) {

                if(scores[row][0] == null) continue;

                if(map.containsKey(scores[row][0])) {
                    map.put(scores[row][0],
                            List.of(
                                    Integer.valueOf(scores[row][1]) + map.get(scores[row][0]).get(0) ,
                                    map.get(scores[row][0]).get(1)+ 1
                            )
                    );
                }else {
                    map.put(scores[row][0], List.of(Integer.valueOf(scores[row][1]), 1));
                }
            }

            for(Map.Entry<String, List<Integer>> entry: map.entrySet()) {

                String key = entry.getKey();
                double tempResult = Math.floor(map.get(key).get(0) / map.get(key).get(1));

                result = Math.max(result, tempResult);
            }

            return (int) result;
        }

        /*
         **  Returns true if the tests pass. Otherwise, returns false;
         */
        public static boolean doTestsPass()
        {
            // TODO: implement more test cases
            String[][] tc1 = { { "Bobby", "87" },
                    { "Charles", "100" },
                    { "Eric", "64" },
                    { "Charles", "22" } };

            String[][] tc2 = { { "Bobby", "39" },
                    { "Charles", "100" },
                    { "Eric", "38" },
                    { "Charles", "22" },
                    { "Charles", "-2" }};

            String[][] tc3 = { { "Bobby", "87" },
                    { "Charles", "100" },
                    { "Eric", "64" },
                    { "Charles", "22" },
                    { null, "22" }};

            String[][] tc4 = { { "Bobby", "55" },
                    { "Charles", "55" },
                    { "Eric", "55" },
                    { "Charles", "55" } };

            return bestAverageGrade(tc1) == 87
                    && bestAverageGrade(tc2) == 40
                    && bestAverageGrade(tc3) == 87
                    && bestAverageGrade(tc4) == 55;
        }

        /*
         **  Execution entry point.
         */
        public static void main(String[] args)
        {
            // Run the tests
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
