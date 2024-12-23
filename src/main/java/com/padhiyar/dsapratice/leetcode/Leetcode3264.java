package com.padhiyar.dsapratice.leetcode;

import java.util.PriorityQueue;

public class Leetcode3264 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0] - b[0] ==0 ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[]{nums[i], i});
        }
        for (int i = 0; i < k; i++) {
            int[] current = minHeap.poll();
            nums[current[1]] = multiplier * nums[current[1]];
            minHeap.add(new int[]{nums[current[1]], current[1]});
        }
        return nums;
    }

    public static void main(String[] args) {
        Leetcode3264 leetCode3264 = new Leetcode3264();
        int[] nums = {1, 2};
        int k = 3;
        int multiplier = 4;
        int[] result = leetCode3264.getFinalState(nums, k, multiplier);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
