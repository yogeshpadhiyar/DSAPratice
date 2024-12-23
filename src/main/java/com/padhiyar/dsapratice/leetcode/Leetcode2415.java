package com.padhiyar.dsapratice.leetcode;

public class Leetcode2415 {
    public static void main(String[] args) {
        Leetcode2415 leetcode2415 = new Leetcode2415();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.right.left.left = new TreeNode(2);
        root.right.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(2);
        leetcode2415.reverseOddLevels(root);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left, root.right, 0);
        return root;
    }

    public static void reverse(TreeNode node1, TreeNode node2 ,int level) {
        if (node1 == null || node2==null) return;
        if (level % 2 == 0) {
            int val = node1.val;
            node1.val = node2.val;
            node2.val = val;
        }
        reverse(node1.left, node2.right,level + 1);
        reverse(node1.right, node2.left ,level + 1);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}