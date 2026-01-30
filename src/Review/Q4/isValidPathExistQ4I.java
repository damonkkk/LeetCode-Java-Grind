package Review.Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Question:
//Write a method isValidPathExist that takes the root and a Predicate<List<Integer>> validator.
//The method should return true if there exists at least one root-to-leaf path that satisfies the validator.
//Note: The validator takes the entire path (as a List of Integers) as input.
//Key Skill: Constructing the path first, then passing the whole list to validator.test(path).
// 首先root to leaf -> check condition will be if node.left == null && node.right== null
// then Predicate<List<Integer>> we need to create arrayList to store the nodes that been treated as int
//
public class isValidPathExistQ4I {
    public boolean isValidPathExist(TreeNode root, Predicate<List<Integer>> validator){
        // check nullability
        if(root == null){
            return false;
        }
        // create the container for the nodes on the path
        ArrayList<Integer> map = new ArrayList<>();
        // recursive step
        return dfs(root,validator,map);
    }

    private boolean dfs(TreeNode node,Predicate<List<Integer>> validator,ArrayList<Integer> map){
        // check the current node is not null
        if(node == null){
            return false;
        }
        // add current node to the path
        map.add(node.val);
        // check if we are in the leaf node
        if(node.left == null && node.right ==null){
            // if the validator is true on that node, we return true for whole
            if(validator.test(map)){
                return true;
            };
        }

        // recursive for left node of current node
        if(dfs(node.left,validator,map)){
            return true;
        }

        // recursive for right node of current node
        if(dfs(node.right,validator,map)){
            return true;
        }

        // back tracking step if we passed through all the test above and did not get true, then we are on a
        // wrong path, we go back one step to explore other possibilities
        map.remove(map.size()-1);
        //if reach there, no valid path
        return false;
    }

    public static void main(String[] args) {



                isValidPathExistQ4I solution = new isValidPathExistQ4I();

                // Test 1: Path with specific sum exists
                System.out.println("Test 1: Path sum equals 22");
                TreeNode root1 = new TreeNode(5);
                root1.left = new TreeNode(4);
                root1.right = new TreeNode(8);
                root1.left.left = new TreeNode(11);
                root1.right.left = new TreeNode(13);
                root1.right.right = new TreeNode(4);
                root1.left.left.left = new TreeNode(7);
                root1.left.left.right = new TreeNode(2);
                root1.right.right.right = new TreeNode(1);

                Predicate<List<Integer>> sumEquals22 = path -> {
                    int sum = 0;
                    for (int val : path) sum += val;
                    return sum == 22;
                };

                boolean result1 = solution.isValidPathExist(root1, sumEquals22);
                System.out.println("Expected: true, Got: " + result1);
                System.out.println(result1 ? "✓ PASS" : "✗ FAIL");
                System.out.println();

                // Test 2: No path satisfies condition
                System.out.println("Test 2: No path sums to 100");
                TreeNode root2 = new TreeNode(1);
                root2.left = new TreeNode(2);
                root2.right = new TreeNode(3);
                root2.left.left = new TreeNode(4);
                root2.left.right = new TreeNode(5);

                Predicate<List<Integer>> sumEquals100 = path -> {
                    int sum = 0;
                    for (int val : path) sum += val;
                    return sum == 100;
                };

                boolean result2 = solution.isValidPathExist(root2, sumEquals100);
                System.out.println("Expected: false, Got: " + result2);
                System.out.println(!result2 ? "✓ PASS" : "✗ FAIL");
                System.out.println();

                // Test 3: Path length requirement
                System.out.println("Test 3: Path length equals 4");
                TreeNode root3 = new TreeNode(1);
                root3.left = new TreeNode(2);
                root3.left.left = new TreeNode(3);
                root3.left.left.left = new TreeNode(4);

                Predicate<List<Integer>> lengthEquals4 = path -> path.size() == 4;

                boolean result3 = solution.isValidPathExist(root3, lengthEquals4);
                System.out.println("Expected: true, Got: " + result3);
                System.out.println(result3 ? "✓ PASS" : "✗ FAIL");
                System.out.println();

                // Test 4: All values must be even
                System.out.println("Test 4: Path with all even values exists");
                TreeNode root4 = new TreeNode(2);
                root4.left = new TreeNode(4);
                root4.right = new TreeNode(3);
                root4.left.left = new TreeNode(6);
                root4.right.right = new TreeNode(8);

                Predicate<List<Integer>> allEven = path -> {
                    for (int val : path) {
                        if (val % 2 != 0) return false;
                    }
                    return true;
                };

                boolean result4 = solution.isValidPathExist(root4, allEven);
                System.out.println("Expected: true, Got: " + result4);
                System.out.println(result4 ? "✓ PASS" : "✗ FAIL");
                System.out.println();

                // Test 5: Single node tree
                System.out.println("Test 5: Single node tree");
                TreeNode root5 = new TreeNode(42);

                Predicate<List<Integer>> containsValue42 = path -> path.contains(42);

                boolean result5 = solution.isValidPathExist(root5, containsValue42);
                System.out.println("Expected: true, Got: " + result5);
                System.out.println(result5 ? "✓ PASS" : "✗ FAIL");
                System.out.println();

                // Summary
                System.out.println("=== Test Summary ===");
                int passed = 0;
                if (result1) passed++;
                if (!result2) passed++;
                if (result3) passed++;
                if (result4) passed++;
                if (result5) passed++;
                System.out.println("Passed: " + passed + "/5 tests");

    }
}
