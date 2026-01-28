package Review.Q4;


import java.util.function.Predicate;

//package Review.Q4;
//Question:
//Write a method countNodes that takes the root of a binary tree and a Predicate<Integer> condition.
//The method should traverse the entire tree and return the count of nodes whose values satisfy the given condition.
//Example: If the predicate is x -> x % 2 == 0, count all even nodes.
//Key Skill: Calling condition.test(node.val).
public class countNodesQ4E {
    private int count = 0;
    public int countNodes(TreeNode root, Predicate<Integer> condition){
        if(root==null){
            return  0;
        }
        count = 0;
        dfs(root,condition);
        return count;
    }

    private void dfs(TreeNode node, Predicate<Integer> condition){
        if(node != null) {
            if (condition.test(node.val)) {
                count++;
            }

            if (node.left != null) {
                dfs(node.left, condition);
            }
            if (node.right != null) {
                dfs(node.right, condition);
            }


        }
}



    public static void main(String[] args) {
        countNodesQ4E solution = new countNodesQ4E();

        System.out.println("=".repeat(70));
        System.out.println("COMPREHENSIVE TEST CASES FOR countNodes()");
        System.out.println("=".repeat(70));

        // TEST 1: Empty tree
        System.out.println("\n[TEST 1] Empty Tree (null root)");
        System.out.println("Tree: null");
        Predicate<Integer> isEven = x -> x % 2 == 0;
        int result = solution.countNodes(null, isEven);
        System.out.println("Condition: x -> x % 2 == 0 (count evens)");
        System.out.println("Result: " + result);
        System.out.println("Expected: 0");
        System.out.println(result == 0 ? "✅ PASS" : "❌ FAIL");

        // TEST 2: Single node - satisfies condition
        System.out.println("\n[TEST 2] Single Node (even)");
        TreeNode t2 = new TreeNode(4);
        System.out.println("Tree: [4]");
        result = solution.countNodes(t2, isEven);
        System.out.println("Condition: x -> x % 2 == 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 1");
        System.out.println(result == 1 ? "✅ PASS" : "❌ FAIL");

        // TEST 3: Single node - doesn't satisfy condition
        System.out.println("\n[TEST 3] Single Node (odd)");
        TreeNode t3 = new TreeNode(5);
        System.out.println("Tree: [5]");
        result = solution.countNodes(t3, isEven);
        System.out.println("Condition: x -> x % 2 == 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 0");
        System.out.println(result == 0 ? "✅ PASS" : "❌ FAIL");

        // TEST 4: All nodes satisfy condition
        System.out.println("\n[TEST 4] All Nodes Satisfy Condition");
        TreeNode t4 = new TreeNode(2);
        t4.left = new TreeNode(4);
        t4.right = new TreeNode(6);
        t4.left.left = new TreeNode(8);
        System.out.println("Tree: [2, 4, 6, 8]");
        System.out.println("      2");
        System.out.println("     / \\");
        System.out.println("    4   6");
        System.out.println("   /");
        System.out.println("  8");
        result = solution.countNodes(t4, isEven);
        System.out.println("Condition: x -> x % 2 == 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 4");
        System.out.println(result == 4 ? "✅ PASS" : "❌ FAIL");

        // TEST 5: No nodes satisfy condition
        System.out.println("\n[TEST 5] No Nodes Satisfy Condition");
        TreeNode t5 = new TreeNode(1);
        t5.left = new TreeNode(3);
        t5.right = new TreeNode(5);
        t5.left.left = new TreeNode(7);
        System.out.println("Tree: [1, 3, 5, 7]");
        System.out.println("      1");
        System.out.println("     / \\");
        System.out.println("    3   5");
        System.out.println("   /");
        System.out.println("  7");
        result = solution.countNodes(t5, isEven);
        System.out.println("Condition: x -> x % 2 == 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 0");
        System.out.println(result == 0 ? "✅ PASS" : "❌ FAIL");

        // TEST 6: Mixed - some satisfy, some don't
        System.out.println("\n[TEST 6] Mixed: Some Even, Some Odd");
        TreeNode t6 = new TreeNode(2);
        t6.left = new TreeNode(4);
        t6.right = new TreeNode(3);
        t6.left.left = new TreeNode(8);
        t6.right.left = new TreeNode(6);
        t6.right.right = new TreeNode(5);
        System.out.println("Tree: [2(even), 4(even), 3(odd), 8(even), 6(even), 5(odd)]");
        System.out.println("        2");
        System.out.println("       / \\");
        System.out.println("      4   3");
        System.out.println("     /   / \\");
        System.out.println("    8   6   5");
        result = solution.countNodes(t6, isEven);
        System.out.println("Condition: x -> x % 2 == 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 4 (nodes: 2, 4, 8, 6)");
        System.out.println(result == 4 ? "✅ PASS" : "❌ FAIL");

        // TEST 7: Different condition - greater than 5
        System.out.println("\n[TEST 7] Different Condition: x > 5");
        TreeNode t7 = new TreeNode(3);
        t7.left = new TreeNode(7);
        t7.right = new TreeNode(5);
        t7.left.left = new TreeNode(10);
        t7.left.right = new TreeNode(6);
        Predicate<Integer> greaterThan5 = x -> x > 5;
        System.out.println("Tree: [3, 7, 5, 10, 6]");
        System.out.println("        3");
        System.out.println("       / \\");
        System.out.println("      7   5");
        System.out.println("     / \\");
        System.out.println("   10   6");
        result = solution.countNodes(t7, greaterThan5);
        System.out.println("Condition: x -> x > 5");
        System.out.println("Result: " + result);
        System.out.println("Expected: 3 (nodes: 7, 10, 6)");
        System.out.println(result == 3 ? "✅ PASS" : "❌ FAIL");

        // TEST 8: Left-skewed tree
        System.out.println("\n[TEST 8] Left-Skewed Tree");
        TreeNode t8 = new TreeNode(1);
        t8.left = new TreeNode(2);
        t8.left.left = new TreeNode(4);
        t8.left.left.left = new TreeNode(8);
        System.out.println("Tree: [1, 2, 4, 8]");
        System.out.println("      1");
        System.out.println("     /");
        System.out.println("    2");
        System.out.println("   /");
        System.out.println("  4");
        System.out.println(" /");
        System.out.println("8");
        result = solution.countNodes(t8, isEven);
        System.out.println("Condition: x -> x % 2 == 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 3 (nodes: 2, 4, 8)");
        System.out.println(result == 3 ? "✅ PASS" : "❌ FAIL");

        // TEST 9: Right-skewed tree
        System.out.println("\n[TEST 9] Right-Skewed Tree");
        TreeNode t9 = new TreeNode(1);
        t9.right = new TreeNode(3);
        t9.right.right = new TreeNode(5);
        t9.right.right.right = new TreeNode(7);
        System.out.println("Tree: [1, 3, 5, 7]");
        System.out.println("1");
        System.out.println(" \\");
        System.out.println("  3");
        System.out.println("   \\");
        System.out.println("    5");
        System.out.println("     \\");
        System.out.println("      7");
        result = solution.countNodes(t9, isEven);
        System.out.println("Condition: x -> x % 2 == 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 0");
        System.out.println(result == 0 ? "✅ PASS" : "❌ FAIL");

        // TEST 10: Condition - divisible by 3
        System.out.println("\n[TEST 10] Condition: x % 3 == 0 (divisible by 3)");
        TreeNode t10 = new TreeNode(3);
        t10.left = new TreeNode(6);
        t10.right = new TreeNode(9);
        t10.left.left = new TreeNode(12);
        t10.left.right = new TreeNode(5);
        t10.right.left = new TreeNode(7);
        Predicate<Integer> divisibleBy3 = x -> x % 3 == 0;
        System.out.println("Tree: [3, 6, 9, 12, 5, 7]");
        System.out.println("        3");
        System.out.println("       / \\");
        System.out.println("      6   9");
        System.out.println("     / \\  /");
        System.out.println("   12  5 7");
        result = solution.countNodes(t10, divisibleBy3);
        System.out.println("Condition: x -> x % 3 == 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 4 (nodes: 3, 6, 9, 12)");
        System.out.println(result == 4 ? "✅ PASS" : "❌ FAIL");

        // TEST 11: Large balanced tree
        System.out.println("\n[TEST 11] Balanced Tree (7 nodes)");
        TreeNode t11 = new TreeNode(10);
        t11.left = new TreeNode(5);
        t11.right = new TreeNode(15);
        t11.left.left = new TreeNode(2);
        t11.left.right = new TreeNode(7);
        t11.right.left = new TreeNode(12);
        t11.right.right = new TreeNode(20);
        System.out.println("Tree: [10, 5, 15, 2, 7, 12, 20]");
        System.out.println("          10");
        System.out.println("         /  \\");
        System.out.println("        5    15");
        System.out.println("       / \\   / \\");
        System.out.println("      2   7 12  20");
        Predicate<Integer> lessThan10 = x -> x < 10;
        result = solution.countNodes(t11, lessThan10);
        System.out.println("Condition: x -> x < 10");
        System.out.println("Result: " + result);
        System.out.println("Expected: 3 (nodes: 5, 2, 7)");
        System.out.println(result == 3 ? "✅ PASS" : "❌ FAIL");

        // TEST 12: Negative numbers
        System.out.println("\n[TEST 12] Tree with Negative Numbers");
        TreeNode t12 = new TreeNode(-2);
        t12.left = new TreeNode(-4);
        t12.right = new TreeNode(3);
        t12.left.left = new TreeNode(-8);
        t12.right.left = new TreeNode(-1);
        Predicate<Integer> isNegative = x -> x < 0;
        System.out.println("Tree: [-2, -4, 3, -8, -1]");
        System.out.println("        -2");
        System.out.println("       /  \\");
        System.out.println("     -4    3");
        System.out.println("    /    /");
        System.out.println("  -8   -1");
        result = solution.countNodes(t12, isNegative);
        System.out.println("Condition: x -> x < 0");
        System.out.println("Result: " + result);
        System.out.println("Expected: 4 (nodes: -2, -4, -8, -1)");
        System.out.println(result == 4 ? "✅ PASS" : "❌ FAIL");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("TEST SUMMARY COMPLETE");
        System.out.println("=".repeat(70));
    }
}
