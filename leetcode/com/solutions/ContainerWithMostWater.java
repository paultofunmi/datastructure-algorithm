package com.solutions;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length -1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left ++;
            }
            else {
                right --;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(ContainerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(ContainerWithMostWater.maxArea(new int[]{1,1}));
    }
}
