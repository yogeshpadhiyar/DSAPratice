package com.padhiyar.dsapratice.leetcode;

public class Leetcode1014 {

    public static void main(String[] args) {
        Leetcode1014 leetcode1014 = new Leetcode1014();
        int[] values = {1,3,1,3,1};
        System.out.println(leetcode1014.maxScoreSightseeingPair(values));
    }

    //score = (values[i] + i) + (values[j] - j)
    //We can precompute the right part (values[j] - j) for all j and use this precomputed information when calculating the score for any i.
    // This allows us to maximize the score efficiently without checking every pair
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = values[n - 1] - (n - 1);

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], values[i] - i);
        }

        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            maxScore = Math.max(maxScore, values[i] + i + suffixMax[i + 1]);
        }

        return maxScore;
    }
}
