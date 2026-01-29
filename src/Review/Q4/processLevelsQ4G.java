package Review.Q4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

//Question:
//Write a method processLevels that takes the root and a Consumer<TreeNode> action.
//The method should perform a Level-Order Traversal (BFS). For every node encountered, perform the given action on that node.
//Example: The action could be node -> System.out.println(node.val) or node -> node.val *= 2.
//Key Skill: Calling action.accept(node).
public class processLevelsQ4G {
    public void processLevels(TreeNode root, Consumer<TreeNode> action){
        // check null first, align with the function signature, if void return nothing, if something else, return empty of its type
        if(root==null){
            return;
        }
        // use queue to initialise linkedlist to use poll, peek etc..
        Queue<TreeNode> tree = new LinkedList<>();
        // add the root as initial node to strat the queue
        tree.add(root);

        // as long as the tree is not empty, we keep going this process
        while(!tree.isEmpty()){
            // first poll the node i.e. retrieve the node and remove  it from the queue
            TreeNode current = tree.poll();
            //action on it as we checked it is not null
            action.accept(current);
            // check the left node of the current node
            if(current.left !=null){
                // if the current left node is not empty then add to the tree (queue) to keep going
                tree.add(current.left);
            }
            // check the right node of the current node
            if(current.right !=null){
                // if the current right node is not empty then add to the tree (queue) to keep going
                tree.add(current.right);
            }
        }

    }

    public static void main(String[] args) {
        processLevelsQ4G solution = new processLevelsQ4G();
        int passed = 0;
        int total = 12;

        // Test 1: Empty tree
        System.out.println("Test 1: Empty tree");
        List<Integer> result1 = new ArrayList<>();
        solution.processLevels(null, node -> result1.add(node.val));
        if (result1.isEmpty()) {
            System.out.println("✅ PASSED");
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected empty, got " + result1);
        }

        // Test 2: Single node
        System.out.println("\nTest 2: Single node");
        TreeNode root2 = new TreeNode(42);
        List<Integer> result2 = new ArrayList<>();
        solution.processLevels(root2, node -> result2.add(node.val));
        if (result2.equals(List.of(42))) {
            System.out.println("✅ PASSED");
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected [42], got " + result2);
        }

        // Test 3: Complete binary tree
        System.out.println("\nTest 3: Complete binary tree");
        /*
                1
               / \
              2   3
             / \
            4   5
        */
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        List<Integer> result3 = new ArrayList<>();
        solution.processLevels(root3, node -> result3.add(node.val));
        if (result3.equals(List.of(1, 2, 3, 4, 5))) {
            System.out.println("✅ PASSED - Level-order: " + result3);
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected [1,2,3,4,5], got " + result3);
        }

        // Test 4: Left-skewed tree
        System.out.println("\nTest 4: Left-skewed tree");
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        List<Integer> result4 = new ArrayList<>();
        solution.processLevels(root4, node -> result4.add(node.val));
        if (result4.equals(List.of(1, 2, 3))) {
            System.out.println("✅ PASSED");
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected [1,2,3], got " + result4);
        }

        // Test 5: Right-skewed tree
        System.out.println("\nTest 5: Right-skewed tree");
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);
        List<Integer> result5 = new ArrayList<>();
        solution.processLevels(root5, node -> result5.add(node.val));
        if (result5.equals(List.of(1, 2, 3))) {
            System.out.println("✅ PASSED");
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected [1,2,3], got " + result5);
        }

        // Test 6: Modify values (multiply by 2)
        System.out.println("\nTest 6: Modify values");
        TreeNode root6 = new TreeNode(10);
        root6.left = new TreeNode(20);
        root6.right = new TreeNode(30);
        solution.processLevels(root6, node -> node.val *= 2);
        if (root6.val == 20 && root6.left.val == 40 && root6.right.val == 60) {
            System.out.println("✅ PASSED - Values doubled: " + root6.val + ", " + root6.left.val + ", " + root6.right.val);
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected 20,40,60, got " + root6.val + "," + root6.left.val + "," + root6.right.val);
        }

        // Test 7: Complex tree
        System.out.println("\nTest 7: Complex tree");
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
               /
              7
        */
        TreeNode root7 = new TreeNode(1);
        root7.left = new TreeNode(2);
        root7.right = new TreeNode(3);
        root7.left.left = new TreeNode(4);
        root7.right.left = new TreeNode(5);
        root7.right.right = new TreeNode(6);
        root7.right.left.left = new TreeNode(7);
        List<Integer> result7 = new ArrayList<>();
        solution.processLevels(root7, node -> result7.add(node.val));
        if (result7.equals(List.of(1, 2, 3, 4, 5, 6, 7))) {
            System.out.println("✅ PASSED - Level-order: " + result7);
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected [1,2,3,4,5,6,7], got " + result7);
        }

        // Test 8: Count nodes
        System.out.println("\nTest 8: Count nodes");
        TreeNode root8 = new TreeNode(1);
        root8.left = new TreeNode(2);
        root8.right = new TreeNode(3);
        root8.left.left = new TreeNode(4);
        int[] count = {0};
        solution.processLevels(root8, node -> count[0]++);
        if (count[0] == 4) {
            System.out.println("✅ PASSED - Count: " + count[0]);
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected count 4, got " + count[0]);
        }

        // Test 9: Sum all values
        System.out.println("\nTest 9: Sum all values");
        TreeNode root9 = new TreeNode(5);
        root9.left = new TreeNode(3);
        root9.right = new TreeNode(8);
        root9.left.left = new TreeNode(1);
        root9.left.right = new TreeNode(4);
        int[] sum = {0};
        solution.processLevels(root9, node -> sum[0] += node.val);
        if (sum[0] == 21) {
            System.out.println("✅ PASSED - Sum: " + sum[0]);
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected sum 21, got " + sum[0]);
        }

        // Test 10: Find max value
        System.out.println("\nTest 10: Find max value");
        TreeNode root10 = new TreeNode(3);
        root10.left = new TreeNode(9);
        root10.right = new TreeNode(20);
        root10.right.left = new TreeNode(15);
        root10.right.right = new TreeNode(7);
        int[] max = {Integer.MIN_VALUE};
        solution.processLevels(root10, node -> max[0] = Math.max(max[0], node.val));
        if (max[0] == 20) {
            System.out.println("✅ PASSED - Max: " + max[0]);
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected max 20, got " + max[0]);
        }

        // Test 11: Collect only even values
        System.out.println("\nTest 11: Collect even values");
        TreeNode root11 = new TreeNode(1);
        root11.left = new TreeNode(2);
        root11.right = new TreeNode(3);
        root11.left.left = new TreeNode(4);
        root11.left.right = new TreeNode(5);
        root11.right.right = new TreeNode(6);
        List<Integer> evens = new ArrayList<>();
        solution.processLevels(root11, node -> {
            if (node.val % 2 == 0) {
                evens.add(node.val);
            }
        });
        if (evens.equals(List.of(2, 4, 6))) {
            System.out.println("✅ PASSED - Evens: " + evens);
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected [2,4,6], got " + evens);
        }

        // Test 12: Print with StringBuilder
        System.out.println("\nTest 12: StringBuilder output");
        TreeNode root12 = new TreeNode(1);
        root12.left = new TreeNode(2);
        root12.right = new TreeNode(3);
        StringBuilder output = new StringBuilder();
        solution.processLevels(root12, node -> output.append(node.val).append(" "));
        if (output.toString().equals("1 2 3 ")) {
            System.out.println("✅ PASSED - Output: \"" + output + "\"");
            passed++;
        } else {
            System.out.println("❌ FAILED: Expected \"1 2 3 \", got \"" + output + "\"");
        }

        // Summary
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESULTS: " + passed + "/" + total + " tests passed");
        if (passed == total) {
            System.out.println("🎉 ALL TESTS PASSED! 🎉");
        } else {
            System.out.println("⚠️  Some tests failed. Review above.");
        }
        System.out.println("=".repeat(50));
    }
}
