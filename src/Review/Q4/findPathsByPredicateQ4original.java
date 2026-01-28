package Review.Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;




////Write a method findPathsByPredicate that takes the root of the tree and a Predicate<List<TreeNode>> condition.
////The method should find all paths from the root to a leaf that satisfy the given predicate condition.
////        (Example: The predicate could be path -> path.size() == 4, meaning find all paths with a length of 4).
////Return: A List<List<TreeNode>> containing all valid paths.
//
public class findPathsByPredicateQ4original {
    public List<List<TreeNode>> findPathsByPredicate(TreeNode root, Predicate<TreeNode> condition){
        List<List<TreeNode>> result = new ArrayList<>();

        List<TreeNode> currentPath = new ArrayList<>();

        if(root==null){
            return result;
        }

        findPaths(root,currentPath,condition,result);

        return result;
    }

    private void findPaths(TreeNode node, List<TreeNode> currentPath, Predicate<TreeNode> condition, List<List<TreeNode>> result){

        currentPath.add(node);

        if(node.left == null && node.right==null){

            if(isValidPath(currentPath, condition)){
                result.add(new ArrayList<>(currentPath));
            }
        } else {

            if(node.left != null){
                findPaths(node.left,currentPath,condition,result);
            }
            if(node.right != null){
                findPaths(node.right,currentPath,condition,result);
            }
        }
        currentPath.remove(currentPath.size() - 1);
    }

    private boolean isValidPath(List<TreeNode> path, Predicate<TreeNode> condition){
        for(TreeNode node: path){
            if(!condition.test(node)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // 构建树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(8);

        findPathsByPredicateQ4original solver = new findPathsByPredicateQ4original();

        // 测试1: 所有节点值 > 4
        List<List<TreeNode>> result1 = solver.findPathsByPredicate(
                root,
                node -> node.val > 4
        );
        System.out.println("节点值都>4的路径:");
        printPaths(result1);  // 输出: [5, 7, 8]

        // 测试2: 所有节点值是奇数
        List<List<TreeNode>> result2 = solver.findPathsByPredicate(
                root,
                node -> node.val % 2 == 1
        );
        System.out.println("节点值都是奇数的路径:");
        printPaths(result2);  // 输出: [5, 3], [5, 7]

        // 测试3: 所有节点值 < 10
        List<List<TreeNode>> result3 = solver.findPathsByPredicate(
                root,
                node -> node.val < 10
        );
        System.out.println("节点值都<10的路径:");
        printPaths(result3);  // 输出: [5, 3, 2], [5, 7, 8]
    }

    private static void printPaths(List<List<TreeNode>> paths) {
        for (List<TreeNode> path : paths) {
            System.out.print("[");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).val);
                if (i < path.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

}
