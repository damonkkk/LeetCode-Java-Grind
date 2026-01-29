package Review.Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Question:
//Write a method mapTreeToList that takes the root of a binary tree and a Function<Integer, String> mapper.
//The method should perform an in-order traversal.
// For each node visited, apply the mapper function to the node's value to convert it to a String,
// and collect these Strings into a List.
//Example: If mapper is x -> "Val:" + x, the list might look like ["Val:1", "Val:5", ...].
//Key Skill: Calling mapper.apply(node.val).
public class mapTreeToListQ4F {
    public List<String> mapTreeToList(TreeNode root, Function<Integer, String> mapper){
        ArrayList<String> result = new ArrayList<>();
        if(root== null){
            return result;
        }
        dfs(root,mapper,result);
        return result;
    }

    private void dfs(TreeNode node, Function<Integer, String> mapper, List<String> result){
        if(node == null){
            return;
        }
        if(node.left !=null){
            dfs(node.left,mapper,result);

        }

        result.add(mapper.apply(node.val));


        if(node.right !=null){
            dfs(node.right,mapper,result);
        }

    }


    public static void main(String[] args) {
        mapTreeToListQ4F solution = new mapTreeToListQ4F();

        // Build a sample tree:
        //       4
        //      / \
        //     2   6
        //    / \ / \
        //   1  3 5  7
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        // Test with different mappers
        Function<Integer, String> mapper1 = x -> "Val:" + x;
        System.out.println("Mapper 1: " + solution.mapTreeToList(root, mapper1));
        // Output: [Val:1, Val:2, Val:3, Val:4, Val:5, Val:6, Val:7]

        Function<Integer, String> mapper2 = x -> "[" + x + "]";
        System.out.println("Mapper 2: " + solution.mapTreeToList(root, mapper2));
        // Output: [[1], [2], [3], [4], [5], [6], [7]]

        Function<Integer, String> mapper3 = x -> x % 2 == 0 ? "EVEN" : "ODD";
        System.out.println("Mapper 3: " + solution.mapTreeToList(root, mapper3));
        // Output: [ODD, EVEN, ODD, EVEN, ODD, EVEN, ODD]
    }
}
