package com.padhiyar.dsapratice.leetcode;

import java.util.Arrays;

public class Leetcode983 {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp,-1);
        return minCostRec(days, costs, 0, dp);
    }

    private int minCostRec(int[] days, int[] costs, int index, int[] dp) {
        if(index >= days.length) return 0;
        if(dp[index] != -1) return dp[index];

        int cost1 = costs[0] + minCostRec(days, costs, index+1, dp);
        int i = index;
        while(i < days.length && days[i] < days[index] + 7) i++;
        int cost2 = costs[1] + minCostRec(days, costs, i, dp);
        while(i < days.length && days[i] < days[index] + 30) i++;
        int cost3 = costs[2] + minCostRec(days, costs, i, dp);

        return dp[index] = Math.min(cost1, Math.min(cost2, cost3));
    }
}
