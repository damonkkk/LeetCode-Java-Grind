package Review.Q4;

//Question:
//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
//A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
//Given the root of a binary tree, return the maximum path sum of any non-empty path.
//Challenge: The path can go from the left subtree, up to the root, and down to the right subtree. You need to handle negative weights correctly.
//LeetCode Reference: #124 Binary Tree Maximum Path Sum
public class maxPathSumQ4B {
    private int maxSum;
    public int maxPathSum(TreeNode root){
        // 初始化maxsum为最小值，以防有负数
        maxSum = Integer.MIN_VALUE;
        // dfs 逻辑
        dfs(root);
        //返回 dfs过后的最大和
        return maxSum;
    }

    private int dfs(TreeNode node){
        // 永远的空树检查
        if( node == null){
            return 0;
        }

        // 1. recursive step， 左右两边都要，因为要历遍每个node
        int left = dfs(node.left);
        int right = dfs(node.right);

        // 2. 取数值left&right，left&right和0比较，如果left&right是负数，那么这个最大值就会是0，不会对已有的最大值的和产生影响
        left = Math.max(left, 0);
        right = Math.max(right, 0);

        // 3. 更新maxSum， 比较已有的maxSum和新发现的路径 即 当前点加比较过后的左右节点
        maxSum = Math.max(maxSum,node.val + left + right);

        // 4. 返回 当前节点数组+左边路径或者右边路径的最大值， 但是为什么呢？
        return node.val + Math.max(left, right);

    }

    public static void main(String[] args) {
        // 测试1
        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        maxPathSumQ4B solution = new maxPathSumQ4B();
        System.out.println("测试1: " + solution.maxPathSum(root1));  // 应该输出42

        // 测试2: 全是负数
        TreeNode root2 = new TreeNode(-3);
        System.out.println("测试2: " + solution.maxPathSum(root2));  // 应该输出-3

        // 测试3: 有负数路径
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(-3);
        root3.right = new TreeNode(2);
        System.out.println("测试3: " + solution.maxPathSum(root3));  // 应该输出7 (5+2)
    }

}
