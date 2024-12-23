package com.padhiyar.dsapratice.leetcode;

import java.util.Stack;

public class Leetcode1475 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> minSuffix = new Stack<>();
        int[] ans = new int[prices.length];
        ans[prices.length-1] = prices[prices.length-1];
        minSuffix.push(prices[prices.length-1]);
        for (int i = prices.length-2; i >=0; i--) {
            while (!minSuffix.isEmpty() && minSuffix.peek()>prices[i]){
                minSuffix.pop();
            }
            if(minSuffix.isEmpty()){
                ans[i] = prices[i];
            }else{
                ans[i] = prices[i] - minSuffix.peek();
            }
            minSuffix.push(prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode1475 leetcode1475 = new Leetcode1475();
        int[] prices = {10,1,1,6};
        int[] result = leetcode1475.finalPrices(prices);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
