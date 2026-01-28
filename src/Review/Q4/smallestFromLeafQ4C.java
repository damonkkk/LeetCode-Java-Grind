package Review.Q4;

import java.util.ArrayList;
import java.util.List;

//
//Question:
//You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
//Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//        (As a reminder, any shorter prefix of a string is lexicographically smaller. For example, "ab" is smaller than "aba".)
//Challenge: You need to construct the path from bottom-up (or reverse it at the end) and compare strings during the traversal.
//LeetCode Reference: #988 Smallest String Starting From Leaf
public class smallestFromLeafQ4C {
    // 1. 设定最小路径为空，
    private  String smallest = null;
    // 2. 容器储存路径
    private List<Integer> path = new ArrayList<>();

    // 3. main body
    public String smallestFromLeaf(TreeNode root){
        smallest = null;  // Reset
        path.clear();     // Clear the path too!
        dfs(root);
        return smallest;
    }

    private void dfs(TreeNode node) {
        // 检查空
        if(node == null){
            return;
        }
        // 把当前节点加入到path
        path.add(node.val);

        // 确实是否为叶节点
        if(node.left ==null && node.right == null){
            // 把这array of characters 转换成 a string with reverse order
            String current = pathToString(path,true);

            // 如果 最小路径（string）为空，或者 当前路径小于当前的最小路径
            if(smallest ==null || current.compareTo(smallest)<0){
                // 更新step： 更新到当前路径为最小路径
                smallest=current;
            }
        }
        //recursive steps
        dfs(node.left);
        dfs(node.right);

        path.remove(path.size() - 1);
    }

    private String pathToString(List<Integer> path, boolean reverse){
        // teach me how to use stringbuilder and its properties
        StringBuilder sb = new StringBuilder();

        // 如果需要reverse
        if(reverse){
            //从后往前
            for(int i = path.size()-1;i>=0;i--){
                //sb添加 (char)('a'+path.get(i))
                //不懂 为什么 添加 (char)('a'+path.get(i))
                // 如果 除去（char）会怎么样
                // 答案 如果没有 cast to （char），结果会是integer而不是ASCII value 的字母
                sb.append((char)('a'+path.get(i)));
            }
        } else {
            for (int val:path){
                //同上
                sb.append((char)('a'+val));
            }
        }
        return sb.toString();
    }




        public static void main(String[] args) {
            smallestFromLeafQ4C solution = new smallestFromLeafQ4C();

            // Test 1: Simple tree
            //     0(a)
            //    / \
            //   1   2
            //  /
            // 3
            // Paths: "dba" (3→1→0), "ca" (2→0)
            // Expected: "ca"
            TreeNode test1 = new TreeNode(0);
            test1.left = new TreeNode(1);
            test1.right = new TreeNode(2);
            test1.left.left = new TreeNode(3);
            System.out.println("Test 1: " + solution.smallestFromLeaf(test1)); // Expected: "ca"


            // Test 2: All same path length
            //     25(z)
            //    /  \
            //   1    3
            //  /      \
            // 1        0
            // Paths: "baz" (1→1→25), "daz" (0→3→25)
            // Expected: "baz"
            TreeNode test2 = new TreeNode(25);
            test2.left = new TreeNode(1);
            test2.right = new TreeNode(3);
            test2.left.left = new TreeNode(1);
            test2.right.right = new TreeNode(0);
            System.out.println("Test 2: " + solution.smallestFromLeaf(test2)); // Expected: "baz"


            // Test 3: Single node (edge case)
            //     0(a)
            // Path: "a"
            // Expected: "a"
            TreeNode test3 = new TreeNode(0);
            System.out.println("Test 3: " + solution.smallestFromLeaf(test3)); // Expected: "a"


            // Test 4: Prefix relationship
            //     0(a)
            //    /
            //   1(b)
            //  / \
            // 2   3
            // Paths: "cba" (2→1→0), "dba" (3→1→0)
            // Expected: "cba"
            TreeNode test4 = new TreeNode(0);
            test4.left = new TreeNode(1);
            test4.left.left = new TreeNode(2);
            test4.left.right = new TreeNode(3);
            System.out.println("Test 4: " + solution.smallestFromLeaf(test4)); // Expected: "cba"


            // Test 5: Longer path wins
            //     2(c)
            //    / \
            //   0   3
            //  /     \
            // 1       0
            // Paths: "bac" (1→0→2), "dc" (0→3→2)
            // Expected: "bac" (even though "dc" is shorter!)
            TreeNode test5 = new TreeNode(2);
            test5.left = new TreeNode(0);
            test5.right = new TreeNode(3);
            test5.left.left = new TreeNode(1);
            test5.right.right = new TreeNode(0);
            System.out.println("Test 5: " + solution.smallestFromLeaf(test5)); // Expected: "bac"


            // Test 6: Right-only tree
            //     4(e)
            //      \
            //       3(d)
            //        \
            //         2(c)
            // Path: "cde"
            // Expected: "cde"
            TreeNode test6 = new TreeNode(4);
            test6.right = new TreeNode(3);
            test6.right.right = new TreeNode(2);
            System.out.println("Test 6: " + solution.smallestFromLeaf(test6)); // Expected: "cde"
        }

}
