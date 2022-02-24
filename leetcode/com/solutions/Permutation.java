package com.solutions;

import java.util.*;

public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        List<String> seen = new ArrayList<>();
        dfs(nums, res, new LinkedList<>(), visited, seen);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, LinkedList<Integer> integers, boolean[] visited, List<String> seen) {

        if(integers.size() == nums.length) {

            StringBuilder stringBuilder1 = new StringBuilder();
            for(Integer curr: integers) {

                stringBuilder1.append(curr);
            }

            String check = stringBuilder1.toString();
            if(!seen.contains(check)) {

                res.add(new LinkedList<>(integers));
                seen.add(check);
            }
            return;
        }

        for(int i =0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                integers.add(nums[i]);
                dfs(nums, res, integers, visited, seen);
                visited[i] = false;
                integers.pollLast();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(Permutation.permute(new int[]{1,2,3}));
        System.out.println(Permutation.permute(new int[]{1,1,2}));
    }
}
