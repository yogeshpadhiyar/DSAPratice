package com.padhiyar.dsapratice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1408 {

    public static void main(String[] args) {
        Leetcode1408 leetcode1408 = new Leetcode1408();
        String[] words = {"blue","red","code"};
        List<String> res = leetcode1408.stringMatching(words);
        for (String re : res) {
            System.out.println(re);
        }
    }

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i!=j && words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    /*public boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }*/
}
