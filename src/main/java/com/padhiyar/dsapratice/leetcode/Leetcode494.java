package com.padhiyar.dsapratice.leetcode;

public class Leetcode494 {
    int count = 0;
    public static void main(String[] args) {
        Leetcode494 leetcode494 = new Leetcode494();
        int[] nums = {1};
        int target = 1;
        System.out.println(leetcode494.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        count = btTargetSum(nums, target, 0, 0, count);
        return count;
    }

    public int btTargetSum(int[] nums, int target, int index, int sum, int count) {
        if(index == nums.length) {
            if(sum == target) {
                count++;
                return count;
            }else return count;
        }
        count = btTargetSum(nums, target, index+1, sum+nums[index], count);
        count = btTargetSum(nums, target, index+1, sum-nums[index], count);
        return count;
    }
}
