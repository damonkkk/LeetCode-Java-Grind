package Review.Q4;

import java.util.ArrayList;

//Question:
//Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//        Note: The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
//Challenge: You need to check every node as a potential starting point for a path.
//LeetCode Reference: #437 Path Sum III
//        code
//
//
public class pathSumFromAnyNodeQ4J {
    public int pathSumFromAnyNode(TreeNode root, int targetSum){
        // 先check这个是不是 null， 如果是 就return 0 因为没有存在的
        if (root == null) return 0;

        // 因为这个function需要return int， 所以 dfs也是return int， 检查目前的节点
        int pathsFromHere = dfs(root, targetSum, 0);

        // 检查目前节点的左边，因为每一个节点都有可能是初始点
        int pathsFromLeft = pathSumFromAnyNode(root.left, targetSum);

       // 同上检查右边
        int pathsFromRight = pathSumFromAnyNode(root.right, targetSum);
        // 返回左中右的符合条件路径的总和
        return pathsFromHere + pathsFromLeft + pathsFromRight;
    }

    private int dfs(TreeNode node, int targetSum, int currentSum){
        // 先初始化 符合条件path 为0
        int totalPath = 0;
        // null 检查
        if(node == null){
            return 0;
        }
        // input 初始化的node总和为零，每条path，每访问一个点就sum他的value
        currentSum += node.val;

        // 如果 满足targetSum的条件 就count +1
        if(currentSum == targetSum){
            totalPath +=1;
        }
        // 检查先节点的left， recursive call
        int left= dfs(node.left,targetSum,currentSum);
        // 同上
        int right=dfs(node.right,targetSum,currentSum);
        // 以目前节点起始的左边的节点符合target的个数加起来
        totalPath += left;
        //同上
        totalPath += right;

        // return 以目前节点起始的符合条件的所有路径
        return totalPath;
        // dfs function 计算从一个特定节点开始往下的所有符合条件的路径。pathSumFromAnyNode function 会把dfs apply到树中的每一个节点作为起始点

    }

    public static void main(String[] args) {
        pathSumFromAnyNodeQ4J solution = new pathSumFromAnyNodeQ4J();

        // Test 1: Simple tree [5,3,2], targetSum = 8
        System.out.println("=== Test 1 ===");
        TreeNode test1 = new TreeNode(5);
        test1.left = new TreeNode(3);
        test1.right = new TreeNode(2);
        int result1 = solution.pathSumFromAnyNode(test1, 8);
        System.out.println("Tree: 5,3,2 | Target: 8");
        System.out.println("Expected: 1 (path [5,3])");
        System.out.println("Your result: " + result1);
        System.out.println("PASS: " + (result1 == 1));
        System.out.println();

        // Test 2: LeetCode example
        System.out.println("=== Test 2 ===");
        TreeNode test2 = new TreeNode(10);
        test2.left = new TreeNode(5);
        test2.right = new TreeNode(-3);
        test2.left.left = new TreeNode(3);
        test2.left.right = new TreeNode(2);
        test2.right.right = new TreeNode(11);
        test2.left.left.left = new TreeNode(3);
        test2.left.left.right = new TreeNode(-2);
        test2.left.right.right = new TreeNode(1);
        int result2 = solution.pathSumFromAnyNode(test2, 8);
        System.out.println("Tree: LeetCode example | Target: 8");
        System.out.println("Expected: 3 (paths [5,3], [5,2,1], [-3,11])");
        System.out.println("Your result: " + result2);
        System.out.println("PASS: " + (result2 == 3));
        System.out.println();

        // Test 3: Single node matching
        System.out.println("=== Test 3 ===");
        TreeNode test3 = new TreeNode(5);
        int result3 = solution.pathSumFromAnyNode(test3, 5);
        System.out.println("Tree: single node 5 | Target: 5");
        System.out.println("Expected: 1 (path [5])");
        System.out.println("Your result: " + result3);
        System.out.println("PASS: " + (result3 == 1));
        System.out.println();

        // Test 4: Path continues after matching
        System.out.println("=== Test 4 ===");
        TreeNode test4 = new TreeNode(5);
        test4.left = new TreeNode(-5);
        test4.left.left = new TreeNode(5);
        int result4 = solution.pathSumFromAnyNode(test4, 0);
        System.out.println("Tree: 5,-5,5 | Target: 0");
        System.out.println("Expected: 2 (paths [5,-5] and [5,-5,5] both sum to 0)");
        System.out.println("Your result: " + result4);
        System.out.println("PASS: " + (result4 == 2));
        System.out.println();

        // Test 5: Empty tree
        System.out.println("=== Test 5 ===");
        int result5 = solution.pathSumFromAnyNode(null, 0);
        System.out.println("Tree: null | Target: 0");
        System.out.println("Expected: 0");
        System.out.println("Your result: " + result5);
        System.out.println("PASS: " + (result5 == 0));
        System.out.println();

        // Test 6: No valid paths
        System.out.println("=== Test 6 ===");
        TreeNode test6 = new TreeNode(1);
        test6.left = new TreeNode(2);
        test6.right = new TreeNode(3);
        int result6 = solution.pathSumFromAnyNode(test6, 10);
        System.out.println("Tree: 1,2,3 | Target: 10");
        System.out.println("Expected: 0");
        System.out.println("Your result: " + result6);
        System.out.println("PASS: " + (result6 == 0));
        System.out.println();

        // Test 7: Path from middle node (not root or leaf)
        System.out.println("=== Test 7 ===");
        TreeNode test7 = new TreeNode(1);
        test7.left = new TreeNode(2);
        test7.left.left = new TreeNode(3);
        int result7 = solution.pathSumFromAnyNode(test7, 5);
        System.out.println("Tree: 1,2,3 (linear) | Target: 5");
        System.out.println("Expected: 1 (path [2,3])");
        System.out.println("Your result: " + result7);
        System.out.println("PASS: " + (result7 == 1));
    }
}
