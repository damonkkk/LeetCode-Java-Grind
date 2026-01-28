package Review.Q4;

import Review.Q4.TreeNode;

import java.util.ArrayList;
import java.util.List;

//package Review.Q4;
//Question:
//You are given the root of a binary tree. A ZigZag path for a binary tree is defined as follow:
//Choose any node in the binary tree and a direction (right or left).
//If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
//Change the direction from right to left or from left to right.
//Repeat the second and third steps until you cannot move in the tree.
//Return the length of the longest ZigZag path contained in that tree.
//Challenge: You need to pass an extra state (direction) in your recursion to track if you came from the left or the right.
//LeetCode Reference: #1372 Longest ZigZag Path in a Binary Tree
public class longestZigZagQ4D {

    // track global maximum
    private int  maxLength= 0 ;
    public int longestZigZag(TreeNode root){
        if(root == null) {
            return 0;
        }
        maxLength = 0;
        // resursive step from left to right direction = 0; since added the root, len =1
        dfs(root.left,0,1);
        // from right to left, direction =1, since added root, len = 1
        dfs(root.right,1,1);
        // return final global max length
        return maxLength;
    }

    private void dfs(TreeNode node, int dir, int len){
        if(node == null){
            return;
        }
        // 为什么一来就先比较 global max len 和 local len？
        // because every node represents a valid zigzag endpoint
        maxLength= Math.max(maxLength,len);

        // 如果是从左往右的情况
        if(dir == 0 ){
            // 因为 开始step 已经是从左往右了，所以如果我们想要有下一步，必须是从右往左，而且，长度要加1
            dfs(node.right,1,len+1);
            // why? and why len == 1?
            dfs(node.left,0,1);
        // from right to left, so next step must be from left to right
        } else {
            dfs(node.left,0,len+1);
            // why? and why len == 1?
            dfs(node.right,1,1);
        }
    }


    public static void main(String[] args) {
        longestZigZagQ4D solution = new longestZigZagQ4D();

        // Test 1: Basic zigzag
        System.out.println("Test 1: Basic zigzag");
        TreeNode test1 = buildTest1();
        System.out.println("Expected: 3, Got: " + solution.longestZigZag(test1));
        System.out.println();

        // Test 2: Single node
        System.out.println("Test 2: Single node");
        TreeNode test2 = new TreeNode(1);
        System.out.println("Expected: 0, Got: " + solution.longestZigZag(test2));
        System.out.println();

        // Test 3: Null tree
        System.out.println("Test 3: Null tree");
        System.out.println("Expected: 0, Got: " + solution.longestZigZag(null));
        System.out.println();

        // Test 4: Only left children
        System.out.println("Test 4: Only left children");
        TreeNode test4 = buildTest4();
        System.out.println("Expected: 1, Got: " + solution.longestZigZag(test4));
        System.out.println();

        // Test 5: Only right children
        System.out.println("Test 5: Only right children");
        TreeNode test5 = buildTest5();
        System.out.println("Expected: 1, Got: " + solution.longestZigZag(test5));
        System.out.println();

        // Test 6: Perfect zigzag
        System.out.println("Test 6: Perfect zigzag");
        TreeNode test6 = buildTest6();
        System.out.println("Expected: 4, Got: " + solution.longestZigZag(test6));
        System.out.println();

        // Test 7: Complex tree
        System.out.println("Test 7: Complex tree");
        TreeNode test7 = buildTest7();
        System.out.println("Expected: 3, Got: " + solution.longestZigZag(test7));
        System.out.println();

        // Test 8: Zigzag in subtree
        System.out.println("Test 8: Zigzag in subtree");
        TreeNode test8 = buildTest8();
        System.out.println("Expected: 2, Got: " + solution.longestZigZag(test8));
        System.out.println();
    }

    // Test 1: Basic zigzag from LeetCode example
    /*
            1
           / \
          2   3
           \
            4
           / \
          5   6
    */
    private static TreeNode buildTest1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        return root;
    }

    // Test 4: Only left children (no zigzag possible)
    /*
            1
           /
          2
         /
        3
    */
    private static TreeNode buildTest4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        return root;
    }

    // Test 5: Only right children (no zigzag possible)
    /*
            1
             \
              2
               \
                3
    */
    private static TreeNode buildTest5() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        return root;
    }

    // Test 6: Perfect zigzag pattern
    /*
            1
           /
          2
           \
            3
           /
          4
           \
            5
    */
    private static TreeNode buildTest6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.left.right = new TreeNode(5);
        return root;
    }

    // Test 7: Complex tree with multiple zigzags
    /*
            1
           / \
          2   3
         / \   \
        4   5   6
           / \
          7   8
    */
    private static TreeNode buildTest7() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        return root;
    }

    // Test 8: Longest zigzag is in subtree, not from root
    /*
            1
           /
          2
         / \
        3   4
             \
              5
             /
            6
    */
    private static TreeNode buildTest8() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.left = new TreeNode(6);
        return root;
    }
}

