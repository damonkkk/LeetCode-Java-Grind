package Review.Q4;

import java.util.ArrayList;
import java.util.List;

//Context:
//Consider a binary tree where each TreeNode contains an integer value representing its weight.
//A "path" is defined as a sequence of nodes from the root down to a leaf node.
//4.a (7 marks)
//Write a method findPathWithSum that takes the root of the tree and an integer targetSum.
//The method should find one path where the sum of all node weights in the path equals targetSum.
//Return: A List<TreeNode> containing the nodes in the path (in order from root to leaf).
//Condition: If no such path exists, return null (or an empty list).

public class findPathWithSumQ4original {
    public List<TreeNode> findPathWithSum(TreeNode root, int targetSum){
        //1. 创建一个arraylist来储存历遍过的点
        List<TreeNode> path = new ArrayList<>();

        // 2. call helper method 三个arguments， 起始点，目标数，和已经历遍过的点
        if(backtrack(root,targetSum,path)){
            // 3. 如果 存在要求中的path， 返回这条path
            return path;
        } else{
            // 4. 如果没有 就不返回什么东西
            return null;
        }

}
    private boolean backtrack(TreeNode node, int remain,List<TreeNode> path){
        // 4. 检查如果是空节点，即起始点是空的，树不存在，直接return false
        // 这回导致主function return null
        if(node == null ){
            return false;
        }

       // 5. 先在arraylist里加上起始节点
        path.add(node);

        //检查 启示节点是否满足一个leaf node的标准，即 这个节点的左右子节点均为空， null
        // 检查这个子节点的value是否和我们要找的vlaue一样
        // 这个要找的value会随着loop减少直至0
        if(node.left == null && node.right==null && remain == node.val){
            //如果满足要求 很好，path 存在，返回true，主function返回path
            return true;
        }



        //循环步骤
        // 自己call自己， 这是上面要求不满足的情况下才会自己call自己
        // 先检查左子节点，相当于把左子节点当作新的起始点，如果满足之前的要求，即找到了最后一个node of the desried path and the value matches
        // 对比的条件需要把当前的value减去新起始点的value，即左子节点的value
        if(backtrack(node.left,remain- node.val,path)){return true;}
        // 同上
        if(backtrack(node.right,remain- node.val,path)){return true;}

        // 如果上面两个都没有返回true，说明此路不通，删点最新访问的节点，即退后一步
        path.remove(path.size()-1);

        //如果啥都没有 返回false，主function返回null
        return false;

    }

    public static void main(String[] args) {
        findPathWithSumQ4original solver = new findPathWithSumQ4original();

        // Constructing the Tree manually for testing
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11  13  4
        //  /  \      \
        // 7    2      1

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("--- Test Case 1: Valid Path (5 -> 4 -> 11 -> 2) ---");
        // Target = 22
        List<TreeNode> result1 = solver.findPathWithSum(root, 22);
        printResult(result1);
        // Expected: [5, 4, 11, 2]

        System.out.println("\n--- Test Case 2: No Path Exists ---");
        // Target = 100
        List<TreeNode> result2 = solver.findPathWithSum(root, 100);
        printResult(result2);
        // Expected: No path found

        System.out.println("\n--- Test Case 3: Partial Path Trap (5 -> 4) ---");
        // Target = 9.
        // Note: 5+4=9, BUT 4 is not a leaf. This should fail.
        List<TreeNode> result3 = solver.findPathWithSum(root, 9);
        printResult(result3);
        // Expected: No path found (because path must end at leaf)

        System.out.println("\n--- Test Case 4: Another Valid Path (5 -> 8 -> 4 -> 1) ---");
        // Target = 18
        List<TreeNode> result4 = solver.findPathWithSum(root, 18);
        printResult(result4);
        // Expected: [5, 8, 4, 1]
    }

    // Helper to print the list of nodes nicely
    private static void printResult(List<TreeNode> path) {
        if (path == null || path.isEmpty()) {
            System.out.println("Result: No path found.");
            return;
        }
        System.out.print("Result: [");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).val);
            if (i < path.size() - 1) System.out.print(" -> ");
        }
        System.out.println("]");
    }


}
