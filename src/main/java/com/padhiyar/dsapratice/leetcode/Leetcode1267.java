package com.padhiyar.dsapratice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1267 {

    public static void main(String[] args) {
        Leetcode1267 leetcode1267 = new Leetcode1267();
//        int[][] grid = new int[][]{{1,0},{1,1}};
        int[][] grid = new int[][]{{1,1,0,0,0},{0,0,1,0,1},{0,0,1,0,0},{1,0,0,1,0},{0,0,0,0,1}};
        System.out.println(leetcode1267.countServers(grid));
    }

    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rowMap = new int[row];
        int[] colMap = new int[col];

//        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==1){
                    rowMap[i]++;
                    colMap[j]++;
//                  q.add(new int[]{i,j});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && (rowMap[i] > 1 || colMap[j] > 1)) {
                    ans++;
                }
            }
        }
        /*while (!q.isEmpty()){
            int[] elm = q.pop();
            int rc = elm[0];
            int cc = elm[1];

            if(rowMap.getOrDefault(rc,0)>1){
                for (int i = 0; i < col; i++) {
                    if(grid[rc][i]==1){
                        ans++;
                        grid[rc][i]=0;
                    }
                }
            }
            if(colMap.getOrDefault(cc,0)>1){
                for (int i = 0; i < row; i++) {
                    if(grid[i][cc]==1){
                        ans++;
                        grid[i][cc]=0;
                    }
                }
            }
        }*/
        return ans;
    }
}
