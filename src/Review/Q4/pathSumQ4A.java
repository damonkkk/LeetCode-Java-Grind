package Review.Q4;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
//Difference from 4.a: You cannot stop after finding the first one; you must traverse the entire tree to find every possible solution.
//LeetCode Reference: #113 Path Sum II
public class pathSumQ4A {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        // 1. 创建容器 最终return list of list
        List<List<Integer>> result = new ArrayList<>();
        // 2. 创建容器 最终list of list 的组成部分，每一个list 都是由valid path上的node的value组成
        List<Integer> currentPath = new ArrayList<>();

        // 3. 检查如果为空树，则没有path
        if(root == null){
            return result;
        }

        // 4. call helper function dfs
        findPath(root,currentPath,0,targetSum,result);
        return result;
    }

    private void findPath(TreeNode node, List<Integer> currentPath,int curretnSum, int targetSum,List<List<Integer>> result ){

        // 1. 把当前node的value 添加到currentPath
        currentPath.add(node.val);
        // 2. curretnSum最开始设置为0， 当添加一个node的时候就添加一次该node的value， 因为我们会和targetsum作比较看经过的路径的value和，是否和target一样
        curretnSum+= node.val;

        // 3. 检查， 题目要求，是从root to leaf， 所以我们检查当前节点是否为leaf， leaf的特征就是左右节点各位 null
        if(node.left == null && node.right==null){
            //4. 检查2， 如果我们当前累计的从 root到当前leaf node的value = targetSum， 那么我们就找到了一条path
            if(curretnSum == targetSum){
                // 5. 创建copy并添加到最终return的list of list 里面， 不太懂why？
                // 因为 如果 result.add（currentPath） 直接添加，因为curretn path只有一条，当我们在trackback的时候，会不断的删去最后一个节点
                // 然后只会剩下最后一条有效path，所以需要独立保存
                result.add(new ArrayList<>(currentPath));
            }
        } else {
            // 6. 结果1 如果当前点的左子节点不是空， recursive call 直到leaf node
            if(node.left != null){
                findPath(node.left,currentPath,curretnSum,targetSum,result);
            }
            // 7. 结果2 如果当前点的右子节点不是空， recursive call 直到leaf node
            if(node.right != null){
                findPath(node.right,currentPath,curretnSum,targetSum,result);
            }
        }
        // 如果当前节点是leaf node，但是currentSum和targetSum却不相等，那么，这就是走错路了，在当前路径上删掉这最新加入的节点
        // 理解错误，这个步骤是回溯的步骤，每一个recursive都要执行，因为我们要历遍所有的节点
        currentPath.remove(currentPath.size()-1);

    }

    public static void main(String[] args) {
        // 构建测试树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

    /*
            5
           / \
          4   12
         /   / \
        11  13  4
       /  \      \
      7    2      1
    */

        pathSumQ4A solution = new pathSumQ4A();
        List<List<Integer>> result = solution.pathSum(root, 22);

        System.out.println("Target sum = 22");
        System.out.println("找到的路径:");
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }

}
