//package Review.Q4;
//Question:
//Write a method mapTreeToList that takes the root of a binary tree and a Function<Integer, String> mapper.
//The method should perform an in-order traversal. For each node visited, apply the mapper function to the node's value to convert it to a String, and collect these Strings into a List.
//Example: If mapper is x -> "Val:" + x, the list might look like ["Val:1", "Val:5", ...].
//Key Skill: Calling mapper.apply(node.val).
//public class mapTreeToListQ4F {
//    public List<String> mapTreeToList(TreeNode root, Function<Integer, String> mapper);
//}
