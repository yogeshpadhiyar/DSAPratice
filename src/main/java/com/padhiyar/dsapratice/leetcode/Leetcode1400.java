package com.padhiyar.dsapratice.leetcode;

public class Leetcode1400 {

    public static void main(String[] args) {
        Leetcode1400 leetcode1400 = new Leetcode1400();
        System.out.println(leetcode1400.canConstruct("true", 4));
    }

    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        if (s.length() == k)
            return true;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1)
                odd++;
        }
        return odd <= k;
    }
}
