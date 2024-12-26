package com.padhiyar.dsapratice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode515 {
    public static void main(String[] args) {
        Leetcode515 leetcode515 = new Leetcode515();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(9);
        System.out.println(leetcode515.largestValues(root));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                max = Math.max(max, current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }else{
                ans.add(max);
                max = Integer.MIN_VALUE;
                if(queue.isEmpty()) break;
                queue.add(null);
            }
        }
        return ans;
    }
}
