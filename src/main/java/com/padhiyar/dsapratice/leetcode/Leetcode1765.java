package com.padhiyar.dsapratice.leetcode;

import java.util.*;

public class Leetcode1765 {

    public static void main(String[] args) {
        Leetcode1765 leetcode1765 = new Leetcode1765();
        int[][] isWater = {{0,1},{0,0}};
//        int[][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        int[][] res = leetcode1765.highestPeak(isWater);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        int height = 0;
        int r = isWater.length;
        int c = isWater[0].length;
        int[][] ans = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        Deque<List<Integer>> q = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(isWater[i][j]==1){
                    q.add(Arrays.asList(i,j));
                    visited[i][j]=true;
                }
            }
        }
        q.add(new ArrayList<>());
        int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        while (!q.isEmpty()){
            List<Integer> elm = q.pop();
            if(elm.isEmpty()){
                height++;
                if(!q.isEmpty())    q.add(new ArrayList<>());
            }else {
                int i = elm.get(0);
                int j = elm.get(1);
                ans[i][j] = height;

                for (int[] d : dir) {
                    if (d[0] + i >= 0 && d[0] + i < r && d[1] + j >= 0 && d[1] + j < c && !visited[d[0] + i][d[1] + j]) {
                        q.add(Arrays.asList(d[0] + i, d[1] + j));
                        visited[d[0]+i][d[1]+j] = true;
                    }
                }
            }
        }

        return ans;
    }
}
