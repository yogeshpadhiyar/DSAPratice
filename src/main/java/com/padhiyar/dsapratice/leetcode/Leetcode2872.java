package com.padhiyar.dsapratice.leetcode;

import java.util.*;

public class Leetcode2872 {
    int ans = 0;
    public static void main(String[] args) {
        Leetcode2872 leetcode2872 = new Leetcode2872();
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values = {3,0,6,1,5,2,1};
        int k = 3;
        System.out.println(leetcode2872.solution(n, edges, values, k));
    }
    public int solution(int n, int[][] edges, int[] values, int k) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> temp = adjList.getOrDefault(edge[0], new ArrayList<>());
            temp.add(edge[1]);
            adjList.put(edge[0],temp);
            temp = adjList.getOrDefault(edge[1], new ArrayList<>());
            temp.add(edge[0]);
            adjList.put(edge[1],temp);
        }

        sol(0, -1, adjList, values,k);
        return ans;
    }

    private int sol(int curr, int prev, Map<Integer, List<Integer>> adjList, int[] values, int k) {
        int sum =0;
        List<Integer> subNode = adjList.getOrDefault(curr, new ArrayList<>());
        for(Integer node : subNode){
            if(node == prev) continue;
            sum += sol(node, curr, adjList, values, k);
        }
        sum += values[curr];
        sum = sum%k;
        if(sum ==0) ans++;
        return sum;
    }

}
