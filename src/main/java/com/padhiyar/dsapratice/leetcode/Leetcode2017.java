package com.padhiyar.dsapratice.leetcode;

public class Leetcode2017 {

    public static void main(String[] args) {
        Leetcode2017 leetcode2017 = new Leetcode2017();
//        int[][] grid = {{2,5,4},{1,5,1}};
//        int[][] grid = {{3,3,1},{8,5,2}};
        int[][] grid = {{1,3,1,15},{1,3,3,1}};
//        int[][] grid = {{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}};
        System.out.println(leetcode2017.gridGame(grid));
    }

    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefixSum = new long[n];
        prefixSum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + grid[0][i];
        }
        long top = prefixSum[n - 1];
        long bottom = 0;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            top -= grid[0][i];
            ans = Math.min(ans, Math.max(top, bottom));
            bottom += grid[1][i];
        }
        return ans;
    }
}
