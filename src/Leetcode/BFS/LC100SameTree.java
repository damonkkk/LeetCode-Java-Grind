package Leetcode.BFS;

public class LC100SameTree {
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
              this.left = left;
              this.right = right;
          }
      }
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 1. 完美情况：两个都到底了，都没节点了 -> 一样
            if(p == null && q == null){
                return true;
            }
            // 2. 结构错误：一个有节点，一个没节点 -> 不一样
            // (注意：因为上面已经排除了"两个都空"，这里只剩"一个空一个不空")
            // 3. 值错误：两个都有节点，但数字不一样 -> 不一样
            if(p == null || q == null || p.val != q.val){
                return false;
            }

            // 4. 递归：根节点没问题，去检查 (左 vs 左) 和 (右 vs 右)
            // 只有两边都返回 true，结果才是 true
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        }
    }
}
