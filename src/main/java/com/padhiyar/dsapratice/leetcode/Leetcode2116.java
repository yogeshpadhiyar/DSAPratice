package com.padhiyar.dsapratice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode2116 {

    public static void main(String[] args) {
        Leetcode2116 leetcode2116 = new Leetcode2116();
        System.out.println(leetcode2116.canBeValid(")","0"));
    }

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        Stack<Integer> unl = new Stack<>();
        Stack<Integer> ll = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                if(locked.charAt(i)=='0'){
                    unl.push(i);
                }else{
                    ll.push(i);
                }
            }else{
                if(locked.charAt(i)=='0'){
                    unl.push(i);
                }else {
                    if (ll.isEmpty()) {
                        if (unl.isEmpty()) {
                            return false;
                        } else {
                            unl.pop();
                        }
                    } else {
                        ll.pop();
                    }
                }
            }
        }
        while (!ll.isEmpty() && !unl.isEmpty()){
            if(ll.peek() < unl.peek()){
                ll.pop();
                unl.pop();
            }else{
                return false;
            }
        }
        if(!ll.isEmpty())    return false;
        return unl.size()%2==0;
    }
}
