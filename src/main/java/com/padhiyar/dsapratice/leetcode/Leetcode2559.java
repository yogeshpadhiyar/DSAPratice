package com.padhiyar.dsapratice.leetcode;

import java.util.List;

public class Leetcode2559 {

    static List<Character> vowel = List.of('a','e','i','o','u');

    public static void main(String[] args) {
        Leetcode2559 leetcode2559 = new Leetcode2559();
        String[] words = {"a","e","i"};
        int[][] queries = {{0,2},{0,1},{2,2}};
        int[] ans = leetcode2559.vowelStrings(words,queries);
        for (int an : ans) {
            System.out.println(an);
        }
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] ans = new int[queries.length];
        int[] prefix = new int[n+1];
        for (int i = 1; i <=n; i++) {
            prefix[i] = prefix[i-1] + (isStartEndWithVowel(words[i-1]) ? 1 : 0);
        }
        int i=0;
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            ans[i++] = prefix[r+1] - prefix[l];
        }
        return ans;
    }

    public boolean isStartEndWithVowel(String s){
        return vowel.contains(s.charAt(0)) && vowel.contains(s.charAt(s.length()-1));
    }
}
