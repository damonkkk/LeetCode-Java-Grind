package Leetcode.BFS;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC226InvertBinaryTree {
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
              this.right = right;
          }
      }
//    class Solution {
//        public TreeNode invertTree(TreeNode root) {
//
//            // consider empty case
//            if(root == null ){
//                return root;
//            }
//            //set a temp treenode to store left node
//            TreeNode temp = root.left;
//            //assign right node to current left node (flip1)
//            root.left=root.right;
//            //assign left node to right node (flip2)
//            root.right =temp;
//            // ???
//            invertTree(root.left);
//            // ???
//            invertTree(root.right);
//            return root;
//
//        }
//    }


    class Solution {
              public TreeNode invertTree(TreeNode root){
                  if(root == null){
                      return null;
                  }

                  Queue<TreeNode> q = new LinkedList<>();
                  q.add(root);

                  while(!q.isEmpty() ){
                      TreeNode current = q.poll();

                      TreeNode temp = current.left;
                      current.left = current.right;
                      current.right = temp;
                      if (current.left != null) {
                          q.add(current.left);
                      }
                      if(current.right!=null){
                          q.add(current.right);
                      }

                  }
                  return root;

              }
    }
}
