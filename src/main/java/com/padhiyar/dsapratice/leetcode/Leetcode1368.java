package com.padhiyar.dsapratice.leetcode;

import java.util.*;

public class Leetcode1368 {

    public static void main(String[] args) {
        Leetcode1368 l = new Leetcode1368();
//        int[][] grid = new int[][]{{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
//        int[][] grid = new int[][]{{1,1,3},{3,2,2},{1,1,4}};
        int[][] grid = new int[][]{{1,2},{4,3}};
        System.out.println(l.minCost(grid));
    }

    public int minCost(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = (row *col) +1;
        int[][] dp = new int[row][col];
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dpRow : dp){
            Arrays.fill(dpRow, max);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        dp[0][0]=0;
        while (!q.isEmpty()){
            int[] curr = q.pollFirst();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < dir.length; i++) {
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];
                int w = grid[r][c]==(i+1)?0:1;

                if(nr>=0 && nr <row && nc>=0 && nc<col && dp[r][c]+w < dp[nr][nc]){
                    dp[nr][nc] = dp[r][c]+w;
                    if(w==0)
                        q.offerFirst(new int[]{nr,nc});
                    else
                        q.offerLast(new int[]{nr,nc});
                }
            }
        }
        return dp[row-1][col-1];
    }
}
