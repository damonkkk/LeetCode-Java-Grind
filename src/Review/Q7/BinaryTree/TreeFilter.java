package Review.Q7.BinaryTree;

import java.util.function.Predicate;

public class TreeFilter {
    sealed interface Tree<T> permits TreeLeaf, TreeNode {}
    record TreeLeaf<T>(T value) implements Tree<T> {}        // leaf NOW has a value!
    record TreeNode<T>(Tree<T> left, T value, Tree<T> right) implements Tree<T> {}

    <T> Tree<T> treeFilter(Predicate<T> predicate, Tree<T> tree) {
        return switch (tree) {
            // Leaf stays as Leaf (nothing to filter)
            case TreeLeaf<T> l -> l;
            // Node: check the predicate on current value
            case TreeNode<T>(var l, var v, var r) -> {
                if (predicate.test(v)) {
                    // predicate TRUE → keep as Node, recursively filter children
                    yield new TreeNode<>(treeFilter(predicate, l), v, treeFilter(predicate, r));
                } else {
                    // predicate FALSE → chop children, become a Leaf
                    yield new TreeLeaf<>(v);
                }
            }
        };
    }
}
