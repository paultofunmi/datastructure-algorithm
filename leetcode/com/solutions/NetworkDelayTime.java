package com.solutions;

import java.util.*;

public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], idx -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((edge1, edge2) -> {
            return edge1[1] - edge2[1];
        });
        minHeap.offer(new int[]{k, 0});
        int max = Integer.MIN_VALUE;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (dist.containsKey(curr[0])) continue;
            dist.put(curr[0], curr[1]);
            max = Math.max(max, curr[1]);

            if (adjList.containsKey(curr[0])) {
                for (int[] edge : adjList.get(curr[0])) {
                    minHeap.offer(new int[]{edge[0], edge[1] + curr[1]});
                }
            }
        }

        if (dist.size() != n) return -1;
        else return max;
    }

    public static void main(String[] args) {

        int[][] arr1 = {{2,1,1},{2,3,1},{3,4,1}};
        int[][] arr2 = {{1,2,1}};
        int[][] arr3 = {{1,2,1}};

        System.out.println(NetworkDelayTime.networkDelayTime(arr1, 4,2));
        System.out.println(NetworkDelayTime.networkDelayTime(arr2, 2,1));
        System.out.println(NetworkDelayTime.networkDelayTime(arr3, 2,2));
    }

}
