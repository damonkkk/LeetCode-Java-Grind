package Review.Q7;
import java.util.Queue;

/**
 * A recursive data-type representing a binary tree.
 *
 * A `BinaryTree` may be either:
 * - a `Leaf`, representing an empty tree
 * - or a `Node`, containing a value and two subtrees (left and right).
 *
 * Examples:
 * - Leaf() [an empty tree]
 * - Node(Leaf(), 5, Leaf()) [a single node with value 5]
 * - Node(Node(Leaf(), 1, Leaf()), 3, Node(Leaf(), 4, Leaf())) [root 3, left child 1, right child 4]
 *
 */
sealed interface BinaryTree permits Leaf, Node {}
/**
 * ... switch(x) {
 *      case Leaf() -> ...
 *      case Node(var l, var v, var r) ->
 *          ...[left recursive call] ... [right recursive call] ...)
 * } ... ;
 */

/**
 * Represents an empty subtree in a `BinaryTree`.
 *
 * Used as the base case in recursive tree operations.
 *
 * Example:
 * - Leaf() [an empty binary tree]
 */
record Leaf() implements BinaryTree {}

/**
 * Represents a non-empty subtree in a `BinaryTree`, containing a value and two subtrees.
 *
 * Example:
 * - Node(Leaf(), 7, Leaf()) [a single-node tree with value 7]
 *
 * @param left  The left subtree (may be Leaf or Node)
 * @param value The value stored at this node
 * @param right The right subtree (may be Leaf or Node)
 */
record Node(BinaryTree left, int value, BinaryTree right) implements BinaryTree {}



public class NumNonLeafNodes {



    public int numNonLeafNodes(BinaryTree tree){
        return switch (tree){
            case Leaf()-> 0;
            case Node(var l,var v, var r) -> 1+ numNonLeafNodes(l) + numNonLeafNodes(r);

        };

    }

    void testExercise1() {
        // set up the test trees
        BinaryTree leaf = new Leaf();
        BinaryTree basicTree1 = new Node(leaf, 1, leaf);
        BinaryTree basicTree2 = new Node(leaf, 5, leaf);
        BinaryTree mediumTree1 = new Node(basicTree2, 4, leaf);
        BinaryTree mediumTree2 = new Node(basicTree1, 2, basicTree1);
        BinaryTree complexTree = new Node(mediumTree2, 3, mediumTree1);

        // run the tests
        testEqual(0, numNonLeafNodes(leaf),        "numNonLeafNodes() on leaf");
        testEqual(1, numNonLeafNodes(basicTree1),  "numNonLeafNodes() on basicTree1");
        testEqual(1, numNonLeafNodes(basicTree2),  "numNonLeafNodes() on basicTree2");
        testEqual(2, numNonLeafNodes(mediumTree1), "numNonLeafNodes() on mediumTree1");
        testEqual(3, numNonLeafNodes(mediumTree2), "numNonLeafNodes() on mediumTree2");
        testEqual(6, numNonLeafNodes(complexTree), "numNonLeafNodes() on complexTree");
    }

    void testEqual(int expected, int actual, String label) {
        if (expected == actual) System.out.println("PASS: " + label);
        else System.out.println("FAIL: " + label + " | expected " + expected + " got " + actual);
    }

    public static void main(String[] args) {
        new NumNonLeafNodes().testExercise1();
    }
}
