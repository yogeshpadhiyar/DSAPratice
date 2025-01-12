package com.padhiyar.dsapratice.leetcode;

public class Leetcode2185 {

    public static void main(String[] args) {
        Leetcode2185 leetcode2185 = new Leetcode2185();
        String[] words = { "apple", "app", "apricot", "banana", "apricot" };
        String pref = "ap";
        System.out.println(leetcode2185.prefixCount(words, pref));
    }

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
