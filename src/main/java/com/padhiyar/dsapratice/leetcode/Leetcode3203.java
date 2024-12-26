package com.padhiyar.dsapratice.leetcode;

import java.util.*;

public class Leetcode3203 {

    public static void main(String[] args) {
        Leetcode3203 leetcode3203 = new Leetcode3203();
        int[][] edges1 = {{0,1},{0,2},{0,3}};
//        int[][] edges1 = {{0, 1}, {2, 0}, {3, 2}, {3, 6}, {8, 7}, {4, 8}, {5, 4},{3,5},{3,9}};
        int[][] edges2 = {};
//        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}};
        System.out.println(leetcode3203.minimumDiameterAfterMerge(edges1, edges2));
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        /*Map<Integer,List<Integer>> adjList1 = new HashMap<>();
        Map<Integer,List<Integer>> adjList2 = new HashMap<>();

        createAdjMapOfList(edges1, adjList1);
        createAdjMapOfList(edges2, adjList2);

        int[] minMaxDimTree1 = getMinDiameterOfTree(edges1, adjList1);
        int[] minMaxDimTree2 = getMinDiameterOfTree(edges2, adjList2);
        int max = Math.max(minMaxDimTree1[1], minMaxDimTree2[1]);
        return Math.max(minMaxDimTree1[0]+1+minMaxDimTree2[0], max);*/

        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i = 0; i < n; i++) adj1.add(new ArrayList<>());
        for(int i = 0; i < m; i++) adj2.add(new ArrayList<>());

        for(int[] i : edges1) {
            adj1.get(i[0]).add(i[1]);
            adj1.get(i[1]).add(i[0]);
        }
        for(int[] i : edges2) {
            adj2.get(i[0]).add(i[1]);
            adj2.get(i[1]).add(i[0]);
        }

        // Find Longest Diameter In Tree 1
        boolean[] vis1 = new boolean[n];
        int[] ans1 = fun(adj1, vis1, 0);
        vis1 = new boolean[n];
        ans1 = fun(adj1, vis1, ans1[0]);

        // Find Longest Diameter In Tree 2
        boolean[] vis2 = new boolean[m];
        int[] ans2 = fun(adj2, vis2, 0);
        vis2 = new boolean[m];
        ans2 = fun(adj2, vis2, ans2[0]);

        int maxDiam = Math.max(ans1[1], ans2[1]);
        int combineMax = (ans1[1] + 1) / 2 + (ans2[1] + 1) / 2 + 1;
        return Math.max(maxDiam, combineMax);
    }


    static int[] fun(List<List<Integer>> adj, boolean[] vis, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        int len = 0;
        int last = node;
        while(!q.isEmpty()) {
            int size = q.size();
            len++;
            for(int i = 0; i < size; i++) {
                int temp = q.poll();
                last = temp;
                vis[temp] = true;
                for(int j : adj.get(temp)) {
                    if(!vis[j]) q.add(j);
                }
            }
        }
        return new int[]{last, len - 1};
    }
    public int[] getMinDiameterOfTree(int[][] edges, Map<Integer, List<Integer>> adjList) {
        int minDimTree = Integer.MAX_VALUE;
        int maxDimTree = Integer.MIN_VALUE;
        for (int i = 0; i < adjList.size(); i++) {
            Queue<int[]> next = new ArrayDeque<>();
            boolean[] visited = new boolean[adjList.size()];
            next.add(new int[]{i, 0});
            int eachNodeMaxDepth=0;
            while (!next.isEmpty()) {
                int[] current = next.poll();
                visited[current[0]] = true;
                for (int j = 0; j < adjList.get(current[0]).size(); j++) {
                    if ( adjList.get(current[0]).get(j) > i && !visited[adjList.get(current[0]).get(j)]) {
                        next.add(new int[]{ adjList.get(current[0]).get(j), current[1] + 1});
                    }
                }
                eachNodeMaxDepth = Math.max(eachNodeMaxDepth, current[1]);
            }
            minDimTree = Math.min(minDimTree, eachNodeMaxDepth);
            maxDimTree = Math.max(maxDimTree, eachNodeMaxDepth);
        }
        if(minDimTree== Integer.MAX_VALUE) minDimTree= 0;
        if(maxDimTree== Integer.MIN_VALUE) maxDimTree= 0;
        return new int[]{minDimTree, maxDimTree};
    }

    public static void createAdjMapOfList(int[][] edges, Map<Integer, List<Integer>> adjList) {
        for (int[] edge : edges) {
            List<Integer> temp = adjList.getOrDefault(edge[0], new ArrayList<>());
            temp.add(edge[1]);
            adjList.put(edge[0], temp);
            temp = adjList.getOrDefault(edge[1], new ArrayList<>());
            temp.add(edge[0]);
            adjList.put(edge[1], temp);
        }
    }
}
