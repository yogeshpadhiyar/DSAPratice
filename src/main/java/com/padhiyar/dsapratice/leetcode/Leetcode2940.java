package com.padhiyar.dsapratice.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Leetcode2940 {

    public static void main(String[] args) {
        Leetcode2940 leetcode2940 = new Leetcode2940();
        int[] heights = {5,3,8,2,6,1,4,6};
        int[][] queries = {{0,7},{3,5},{5,2},{3,0},{1,6}};
        int[] ans = leetcode2940.leftmostBuildingQueries(heights,queries);
        for (int an : ans) {
            System.out.println(an);
        }
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        Stack<int[]> s = new Stack<>();
        int[][] dp = new int[n][2];
        dp[n-1][0] = -1;
        dp[n-1][1] = n-1;
        s.add(new int[]{heights[n-1],n-1});
        for (int i = heights.length-2; i >=0; i--) {
            while (!s.isEmpty() && s.peek()[0] < heights[i]){
                s.pop();
            }
            int[] peek = !s.isEmpty()? s.peek() : new int[]{-1,i};
            dp[i][0] = peek[0]<=heights[i] ? -1 : peek[0];
            dp[i][1] = peek[1];
            s.add(new int[]{heights[i], i});
        }
        int[] ans = new int[queries.length];
        int i=0;
        for (int[] q : queries){
            int i1 = q[0];
            int i2 = q[1];
            if(i1==i2)  ans[i] = i1;
            else if(i1<i2 && heights[i1]<=heights[i2])    ans[i] = i2;
            else if(i2<i1 && heights[i2]<=heights[i1])    ans[i] = i1;
            else if(dp[i1][0]==-1 || dp[i2][0]==-1)  ans[i] = -1;
            else {
                int a = dp[i2][0];
                if(heights[i2]>heights[i1]) ans[i] = a;
                else    ans[i] = -1;
//                    int max = Math.max(i1,i2);
//                    ans[i] = dp[max][1];
            }
            i++;
        }
        return ans;
    }
}

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] gr = new int[n];
        LinkedList<Integer> l = new LinkedList<>();
        l.offer(n-1);
        gr[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            while(l.size()>0 && heights[i]>heights[l.peek()])
                l.pop();
            if(l.size()>0)
                gr[i]=l.peek();
            else
                gr[i]=-1;
            l.push(i);
        }
        int[] ans= new int[queries.length];
        int i=0;
        for(int[] a:queries){
            int x = gr[a[0]];
            int y = gr[a[1]];
            if(a[0]==a[1])ans[i++]=a[0];
            else if(a[0]<a[1] && heights[a[0]]<heights[a[1]])
                ans[i++]=a[1];
            else if(a[1]<a[0] && heights[a[1]]<heights[a[0]])
                ans[i++]=a[0];
            else if(x==-1 || y==-1)ans[i++]=-1;
            else{
                int m = Math.max(a[0],a[1]);
                while(m<heights.length && m!=-1 && (heights[m]<=heights[a[0]] || heights[m]<=heights[a[1]]))
                    m = gr[m];
                if(m>=heights.length || m==-1)
                    ans[i++]=-1;
                else ans[i++]=m;
            }
        }
        return ans;
    }
}