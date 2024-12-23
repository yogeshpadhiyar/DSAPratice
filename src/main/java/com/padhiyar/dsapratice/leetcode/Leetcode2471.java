package com.padhiyar.dsapratice.leetcode;

import java.util.*;

public class Leetcode2471 {

    public static void main(String[] args) {
        Leetcode2471 leetcode2471 = new Leetcode2471();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(5);
//        root.left.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(1);
//        root.left.right.left = new TreeNode(1);
//        root.left.right.right = new TreeNode(1);
//        root.right.left.left = new TreeNode(9);
//        root.right.left.right = new TreeNode(2);
//        root.right.right.left = new TreeNode(10);
//        root.right.right.right = new TreeNode(2);
        System.out.println(leetcode2471.minimumOperations(root));
    }

    public int minimumOperations(TreeNode root) {
        Map<Integer, List<Integer>> levelWiseList = new HashMap<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> levelList = new ArrayList<>();
        while (!q.isEmpty()){
            TreeNode poll = q.poll();
            if(poll == null){
                levelWiseList.put(levelWiseList.size(),levelList);
                levelList = new ArrayList<>();
                if(q.isEmpty()) break;
                q.add(null);
            }else{
                levelList.add(poll.val);
                if(poll.left!=null) q.add(poll.left);
                if(poll.right!=null) q.add(poll.right);
            }
        }
        int ans = 0;
        for(List<Integer> ll : levelWiseList.values()){
            List<Integer> lldup = new ArrayList<>(ll);
            Collections.sort(lldup);
            Map<Integer,Integer> indexMap = new HashMap<>();
            for (int i = 0; i < lldup.size(); i++) {
                indexMap.put(lldup.get(i),i);
            }
            int i=0;
            while(i<ll.size()){
                int actualIndex = indexMap.get(ll.get(i));
                if(actualIndex == i)    i++;
                else{
                    int temp = ll.get(i);
                    ll.set(i,ll.get(actualIndex));
                    ll.set(actualIndex,temp);
                    ans++;
                }
            }
        }
        return ans;
    }
}

