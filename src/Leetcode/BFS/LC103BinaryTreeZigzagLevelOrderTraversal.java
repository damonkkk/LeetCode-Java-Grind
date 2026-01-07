package Leetcode.BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC103BinaryTreeZigzagLevelOrderTraversal {
    /**
     * Definition for a binary tree node.

     */
     public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode() {
        }


        TreeNode(int val) {
            this.val = val;
        }


        TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
     }
    }
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null){
                return res;
            }
            Deque<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean zig = true;

            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> list = new ArrayList<>();

                for(int i = 0; i<size; i ++){
                    TreeNode current = q.poll();

                    if(zig){
                        list.add(current.val);
                    }
                    else{
                        list.add(0,current.val);
                    }

                    if(current.left != null){
                        q.add(current.left);
                    }
                    if(current.right!= null){
                        q.add(current.right);
                    }
                }
                res.add(list);
                zig = !zig;
            }

            return res;
        }

    }
}
