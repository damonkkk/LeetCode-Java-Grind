package Review.Q4;

import java.util.function.Predicate;

//Question:
//Write a method findFirst that takes the root and a Predicate<TreeNode> condition.
//The method should perform a DFS (Pre-order) traversal. It should return the first node that satisfies the condition. If found, stop searching immediately and return that node. If not found, return null.
//Key Skill: Using the boolean result of condition.test(node) to decide whether to return immediately or continue recursion.
public class findFirstQ4H {
    public TreeNode findFirst(TreeNode root, Predicate<TreeNode> condition){
        if(root == null){
            // the signature requires a node meet the condition, but what if root is null?
            return null;
        }
         if(condition.test(root)){
             return root;
         }



        TreeNode leftnode = findFirst(root.left, condition);
        if (leftnode != null) {
            return leftnode;
        }

        TreeNode rightnode = findFirst(root.right, condition);
        return rightnode;


    }
    public static void main(String[] args) {
        findFirstQ4H solution = new findFirstQ4H();

        System.out.println("=".repeat(70));
        System.out.println("COMPREHENSIVE TEST CASES FOR findFirst()");
        System.out.println("=".repeat(70));

        // TEST 1: Empty tree
        System.out.println("\n[TEST 1] Empty Tree (null root)");
        System.out.println("Tree: null");
        Predicate<TreeNode> greaterThan5 = node -> node.val > 5;
        TreeNode result = solution.findFirst(null, greaterThan5);
        System.out.println("Condition: node -> node.val > 5");
        System.out.println("Result: " + result);
        System.out.println("Expected: null");
        System.out.println(result == null ? "✅ PASS" : "❌ FAIL");

        // TEST 2: Single node - satisfies condition
        System.out.println("\n[TEST 2] Single Node (satisfies condition)");
        TreeNode t2 = new TreeNode(10);
        System.out.println("Tree: [10]");
        result = solution.findFirst(t2, greaterThan5);
        System.out.println("Condition: node -> node.val > 5");
        System.out.println("Result: " + (result != null ? result.val : "null"));
        System.out.println("Expected: 10");
        System.out.println(result != null && result.val == 10 ? "✅ PASS" : "❌ FAIL");

        // TEST 3: Single node - doesn't satisfy condition
        System.out.println("\n[TEST 3] Single Node (doesn't satisfy condition)");
        TreeNode t3 = new TreeNode(3);
        System.out.println("Tree: [3]");
        result = solution.findFirst(t3, greaterThan5);
        System.out.println("Condition: node -> node.val > 5");
        System.out.println("Result: " + result);
        System.out.println("Expected: null");
        System.out.println(result == null ? "✅ PASS" : "❌ FAIL");

        // TEST 4: Match found at root
        System.out.println("\n[TEST 4] Match Found at Root");
        System.out.println("Tree structure:");
        System.out.println("       8");
        System.out.println("      / \\");
        System.out.println("     3   10");
        TreeNode t4 = new TreeNode(8);
        t4.left = new TreeNode(3);
        t4.right = new TreeNode(10);
        result = solution.findFirst(t4, greaterThan5);
        System.out.println("Condition: node -> node.val > 5");
        System.out.println("Result: " + (result != null ? result.val : "null"));
        System.out.println("Expected: 8 (root)");
        System.out.println(result != null && result.val == 8 && result == t4 ? "✅ PASS" : "❌ FAIL");

        // TEST 5: Match found in left subtree
        System.out.println("\n[TEST 5] Match Found in Left Subtree");
        System.out.println("Tree structure:");
        System.out.println("       2");
        System.out.println("      / \\");
        System.out.println("     7   4");
        System.out.println("    /");
        System.out.println("   1");
        TreeNode t5 = new TreeNode(2);
        t5.left = new TreeNode(7);
        t5.right = new TreeNode(4);
        t5.left.left = new TreeNode(1);
        result = solution.findFirst(t5, greaterThan5);
        System.out.println("Condition: node -> node.val > 5");
        System.out.println("Result: " + (result != null ? result.val : "null"));
        System.out.println("Expected: 7 (first node > 5 in pre-order)");
        System.out.println(result != null && result.val == 7 ? "✅ PASS" : "❌ FAIL");

        // TEST 6: Match found in right subtree only
        System.out.println("\n[TEST 6] Match Found in Right Subtree Only");
        System.out.println("Tree structure:");
        System.out.println("       3");
        System.out.println("      / \\");
        System.out.println("     2   9");
        TreeNode t6 = new TreeNode(3);
        t6.left = new TreeNode(2);
        t6.right = new TreeNode(9);
        result = solution.findFirst(t6, greaterThan5);
        System.out.println("Condition: node -> node.val > 5");
        System.out.println("Result: " + (result != null ? result.val : "null"));
        System.out.println("Expected: 9");
        System.out.println(result != null && result.val == 9 ? "✅ PASS" : "❌ FAIL");

        // TEST 7: No match found
        System.out.println("\n[TEST 7] No Match Found");
        System.out.println("Tree structure:");
        System.out.println("       1");
        System.out.println("      / \\");
        System.out.println("     2   3");
        System.out.println("    / \\");
        System.out.println("   4   5");
        TreeNode t7 = new TreeNode(1);
        t7.left = new TreeNode(2);
        t7.right = new TreeNode(3);
        t7.left.left = new TreeNode(4);
        t7.left.right = new TreeNode(5);
        result = solution.findFirst(t7, node -> node.val > 100);
        System.out.println("Condition: node -> node.val > 100");
        System.out.println("Result: " + result);
        System.out.println("Expected: null");
        System.out.println(result == null ? "✅ PASS" : "❌ FAIL");

        // TEST 8: Pre-order verification (multiple matches)
        System.out.println("\n[TEST 8] Pre-order Verification (Multiple Matches)");
        System.out.println("Tree structure:");
        System.out.println("       8");
        System.out.println("      / \\");
        System.out.println("     7   9");
        System.out.println("    /");
        System.out.println("   10");
        TreeNode t8 = new TreeNode(8);
        t8.left = new TreeNode(7);
        t8.right = new TreeNode(9);
        t8.left.left = new TreeNode(10);
        result = solution.findFirst(t8, greaterThan5);
        System.out.println("Condition: node -> node.val > 5");
        System.out.println("Pre-order: 8, 7, 10, 9");
        System.out.println("Result: " + (result != null ? result.val : "null"));
        System.out.println("Expected: 8 (first in pre-order)");
        System.out.println(result != null && result.val == 8 && result == t8 ? "✅ PASS" : "❌ FAIL");

        // TEST 9: Early termination test
        System.out.println("\n[TEST 9] Early Termination (stops when found)");
        System.out.println("Tree structure:");
        System.out.println("       3");
        System.out.println("      / \\");
        System.out.println("     8   12");
        TreeNode t9 = new TreeNode(3);
        t9.left = new TreeNode(8);
        t9.right = new TreeNode(12);
        result = solution.findFirst(t9, greaterThan5);
        System.out.println("Condition: node -> node.val > 5");
        System.out.println("Result: " + (result != null ? result.val : "null"));
        System.out.println("Expected: 8 (should stop, not continue to 12)");
        System.out.println(result != null && result.val == 8 && result == t9.left ? "✅ PASS" : "❌ FAIL");}



}
