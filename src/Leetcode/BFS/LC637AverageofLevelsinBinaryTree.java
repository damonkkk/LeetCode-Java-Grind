package Leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC637AverageofLevelsinBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int size = q.size();
                Double total = 0.0;

                for(int i = 0; i<size; i++){
                    TreeNode current = q.poll();
                    total += current.val;
                    if(current.left != null){
                        q.add(current.left);
                    }
                    if(current.right != null){
                        q.add(current.right);
                    }
                }
                total = total/ size;
                result.add(total);

            }
            return result;

        }
    }

}
