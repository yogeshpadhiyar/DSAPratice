package com.padhiyar.dsapratice.leetcode;

public class Leetcode3042 {

    public static void main(String[] args) {
        Leetcode3042 leetcode3042 = new Leetcode3042();
        String[] words = { "abab","ab"};
        System.out.println(leetcode3042.countPrefixSuffixPairs(words));
    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffixPair(String word1, String word2) {
        return word1.startsWith(word2) && word1.endsWith(word2);
    }
}
