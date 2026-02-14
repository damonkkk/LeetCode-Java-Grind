package Review.Q7;

public class MaxDepth {

    public int maxDepth(BinaryTree tree){
        if(tree ==null){
            return 0;
        }

        return switch (tree){
            case Leaf()-> 0;
            case Node(var l,var v, var r) -> 1+ Math.max(maxDepth(l), maxDepth(r));

        };


    }


    void testExercise2() {
        BinaryTree leaf = new Leaf();
        BinaryTree basicTree1 = new Node(leaf, 1, leaf);
        BinaryTree basicTree2 = new Node(leaf, 5, leaf);
        BinaryTree mediumTree1 = new Node(basicTree2, 4, leaf);
        BinaryTree mediumTree2 = new Node(basicTree1, 2, basicTree1);
        BinaryTree complexTree = new Node(mediumTree2, 3, mediumTree1);

        testEqual(0, maxDepth(leaf),        "maxDepth() on leaf");
        testEqual(1, maxDepth(basicTree1),  "maxDepth() on basicTree1");
        testEqual(1, maxDepth(basicTree2),  "maxDepth() on basicTree2");
        testEqual(2, maxDepth(mediumTree1), "maxDepth() on mediumTree1");
        testEqual(2, maxDepth(mediumTree2), "maxDepth() on mediumTree2");
        testEqual(3, maxDepth(complexTree), "maxDepth() on complexTree");
    }

    void testEqual(int expected, int actual, String label) {
        if (expected == actual) System.out.println("PASS: " + label);
        else System.out.println("FAIL: " + label + " | expected " + expected + " got " + actual);
    }

    public static void main(String[] args) {
        new MaxDepth().testExercise2();
    }

}
