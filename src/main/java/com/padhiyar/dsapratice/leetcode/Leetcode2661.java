package com.padhiyar.dsapratice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2661 {

    public static void main(String[] args) {
        Leetcode2661 leetcode2661 = new Leetcode2661();
        int[] arr = { 2,8,7,4,1,3,5,6,9};
        int[][] mat = { {3,2,5}, {1,4,6},{8,7,9} };
        System.out.println(leetcode2661.firstCompleteIndex(arr, mat));
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> elePosition = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                elePosition.put(mat[i][j], new int[]{i,j});
            }
        }
        Map<Integer, Integer> rowFiller = new HashMap<>();
        Map<Integer, Integer> colFiller = new HashMap<>();
        row = mat[0].length;
        col = mat.length;
        for (int k = 0; k < arr.length; k++) {
            int ele = arr[k];
            int[] pos = elePosition.get(ele);
            int rowFillCount = rowFiller.getOrDefault(pos[0],0);
            if(rowFillCount+1 ==row)
                return k;
            else{
                rowFiller.put(pos[0],rowFillCount+1);
            }
            int colFillCount = colFiller.getOrDefault(pos[1],0);
            if(colFillCount+1 ==col)
                return k;
            else{
                colFiller.put(pos[1],colFillCount+1);
            }
        }
        return row*col;
    }
}
