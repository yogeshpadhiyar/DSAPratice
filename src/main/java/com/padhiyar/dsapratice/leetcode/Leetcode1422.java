package com.padhiyar.dsapratice.leetcode;

public class Leetcode1422 {

    public static void main(String[] args) {
        Leetcode1422 leetcode1422 = new Leetcode1422();
        System.out.println(leetcode1422.maxScore("1111"));
    }

    public int maxScore(String s) {
        int n = s.length();
        int[] zeros = new int[n];
        int countZero=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)=='0'){
                countZero++;
            }
            zeros[i] = countZero;
        }
        int maxScore = 0;
        int countOne = 0;
        int[] ones = new int[n];
        for (int i = n-2; i >=0; i--) {
            if(s.charAt(i+1)=='1'){
                countOne++;
            }
            ones[i] = countOne;
        }
        for (int i = 1; i < n; i++) {
            maxScore = Math.max(maxScore, zeros[i]+ones[i-1]);
        }
        return maxScore;
    }
}
