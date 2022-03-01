package com.solutions;

import java.util.*;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls.
 *
 * The start and destination coordinates are represented by row and column indexes
 */
public class MazeII {

    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };

        int[] start = {0,4};
        int[] dest = {4,4}; //output = true

        int[][] maze1 = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };

        int[] start1 = {0,4};
        int[] dest1 = {3,2}; //output = false

        int[][] maze2 = {
                {0,0,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {0,1,0,0,1},
                {0,1,0,0,0}
        };

        int[] start2 = {4,3};
        int[] dest2 = {0,1}; //output = false

        System.out.println(MazeII.checkMaze(maze, start, dest));
        System.out.println(MazeII.checkMaze(maze1, start1, dest1));
        System.out.println(MazeII.checkMaze(maze2, start2, dest2));
    }

    public static int checkMaze(int[][] maze, int[] start, int[] dest) {

        int[][] directions = {{-1, 0}, {1,0}, {0, 1}, {0, -1}};
        Queue<int[][]> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        int[][] start1 = {start, {0}};
        queue.add(start1);
        seen.add(start[0] +","+ start[1]);

        while(queue.size() > 0) {
            int[][] currentPositionCounter = queue.poll();
            int[] currentPosition = currentPositionCounter[0];

            if(currentPosition[0] == dest[0] && currentPosition[1] == dest[1]) return currentPositionCounter[1][0];

            for(int[] d: directions) {

                int currentDistance = currentPositionCounter[1][0];

                int[] newPosition = {currentPosition[0], currentPosition[1]};

                while(
                        newPosition[0] + d[0] >= 0 && newPosition[0] + d[0] < maze.length
                        && newPosition[1] + d[1] >= 0 && newPosition[1] + d[1] < maze[0].length
                        && maze[newPosition[0] + d[0]][newPosition[1] + d[1]] == 0
                ) {
                    newPosition[0] += d[0];
                    newPosition[1] += d[1];
                    currentDistance++;
//                    System.out.println("cP: " + Arrays.toString(currentPosition) + ", nP: " + Arrays.toString(newPosition) + ", distance:" + currentDistance);
                }

                if(!seen.contains(newPosition[0] +","+ newPosition[1])) {
                    int[][] newCoord = { newPosition, {currentDistance}};
                    queue.add(newCoord);
                    seen.add(newPosition[0] +","+ newPosition[1]);
                }
            }
        }

        return -1;
    }
}
