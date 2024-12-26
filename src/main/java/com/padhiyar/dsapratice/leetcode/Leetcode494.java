package com.padhiyar.dsapratice.leetcode;

import java.util.Arrays;

public class Leetcode494 {
    int count = 0;
    public static void main(String[] args) {
        Leetcode494 leetcode494 = new Leetcode494();
        int[] nums = {1};
        int target = -1;
        System.out.println(leetcode494.findTargetSumWaysUsingDP(nums, target));
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

    public int findTargetSumWaysUsingDP(int[] nums, int target) {
        int[][] dp = new int[nums.length][3003];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return dpTargetSum(nums, target, 0, dp);
    }

    // use 1000 plus to avoid negative index
    private int dpTargetSum(int[] nums, int target, int i, int[][] dp) {
        if(i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        if(dp[i][target+1000] != -1) {
            return dp[i][target+1000];
        }
        int ans = 0;
        ans += dpTargetSum(nums, target + nums[i], i+1, dp);
        ans += dpTargetSum(nums, target - nums[i], i+1, dp);
        return dp[i][target+1000] = ans;
    }
}
