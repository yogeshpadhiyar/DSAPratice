package com.padhiyar.dsapratice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode916 {

    public static void main(String[] args) {
        Leetcode916 leetcode916 = new Leetcode916();
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","l"};
        List<String> ans = leetcode916.wordSubsets(words1, words2);
        for (String an : ans) {
            System.out.println(an);
        }
    }

    public List<String> wordSubsets(String[] words1, String[] words2){
        int[] maxCharFreq = new int[26];
        int[] tmpCharFreq = new int[26];

        for(String s : words2){
            for(char c : s.toCharArray()){
                tmpCharFreq[c-'a']++;
                maxCharFreq[c-'a'] = Math.max(maxCharFreq[c-'a'], tmpCharFreq[c-'a']);
            }
            tmpCharFreq = new int[26];
        }

        List<String> ans = new ArrayList<>();
        for(String w : words1){
            tmpCharFreq = new int[26];
            for(char c : w.toCharArray()){
                tmpCharFreq[c-'a']++;
            }
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if(tmpCharFreq[i] < maxCharFreq[i]){
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal) ans.add(w);
        }
        return ans;
    }

    public List<String> wordSubsetsTLEError(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        boolean[] universal = new boolean[words1.length];
        for (int i = 0; i < words1.length; i++) {
            for (String w2 : words2) {
                if(!isSubset(words1[i], w2)){
                    universal[i] = false;
                    break;
                }
                universal[i] = true;
            }
            if(universal[i])    ans.add(words1[i]);
        }
        return ans;
    }

    public boolean isSubset(String w1, String w2){
        HashMap<Character,Integer> freq1 = new HashMap<>();
        for (char c : w1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> freq2 = new HashMap<>();
        for (char c : w2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c,0)+1);
        }
        for (char c : freq2.keySet()) {
            if(freq1.getOrDefault(c,0) < freq2.get(c)) return false;
        }
        return true;
    }
}
