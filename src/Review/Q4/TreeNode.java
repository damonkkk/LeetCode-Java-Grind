package Review.Q4;

/**
 * Standard definition for a binary tree node.
 * Compatible with LeetCode and your Exam questions.
 */
public class TreeNode {
    // Public fields for direct access (Standard in algorithm questions)
    public int val;
    public TreeNode left;
    public TreeNode right;

    // Constructor 1: Empty node
    public TreeNode() {}

    // Constructor 2: Node with a value (Leaf node)
    public TreeNode(int val) {
        this.val = val;
    }

    // Constructor 3: Node with value and children
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Helper method to make printing/debugging easier
    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + '}';
    }


}