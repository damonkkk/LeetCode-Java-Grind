package Leetcode;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class LC104MaximumDepthofBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        //DFS
        // public int maxDepth(TreeNode root) {
        //     // first check if it is an null tree
        //     if(root == null){
        //         return 0;
        //     }
        //     // if it is not, we use self call of this function maxDepth,
        //     // e.g. root.left = 9, if it has child, it will return root.left (as root for 1 level)
        //     // + the 1 level for its child, but in this case is null, so we add the root level and
        //     // root.left level 1+1 =2. now move to root.right = 20, it will return 1 level
        //     // (for root), then call it self set 20 as root level, go left +1 level = 2 levels in
        //     // total, go right +1 level = 2 levels in total, them max(2,2) = 2 and add the actual
        //     // root for 1 level = 3 levels
        //     return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        // }

        //BFS
        public int maxDepth(TreeNode root){
            if(root == null){
                return 0;
            }


            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 0;

            while (!queue.isEmpty()) {
                depth++;
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            return depth;
        }
    }
}
