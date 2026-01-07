package Leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC700SearchinaBinarySearchTree {
    /**
     * Definition for a binary tree node.
     */

          public class TreeNode {
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
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {

            if (root == null) {
                return root;
            }
            while(root!= null && root.val != val){
                if(val< root.val){
                    root = root.left;
                }
                else if(root.val > val){
                    root=root.right;
                } else{
                    break;
                }
            }
            return root;

        }
    }
}
