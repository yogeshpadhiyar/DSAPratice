package com.padhiyar.dsapratice.leetcode;

public class Leetcode769 {
    public int maxChunksToSorted(int[] arr) {
        int ans =0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if(i==max)  ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode769 leetcode769 = new Leetcode769();
        int[] arr = {};
        System.out.println(leetcode769.maxChunksToSorted(arr));
    }
}
