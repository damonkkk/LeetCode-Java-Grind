package Review.Q7;

public class IsPresent {


    public boolean isPresent(BinaryTree tree, int num){

        if(tree ==null){
            return false;
        }

        return switch (tree) {
            case Leaf() -> false;
            case Node(var l, var v, var r) -> v == num || isPresent(l, num) || isPresent(r, num);
        };



    }


    void testExercise3() {
        BinaryTree leaf = new Leaf();
        BinaryTree basicTree1 = new Node(leaf, 1, leaf);
        BinaryTree basicTree2 = new Node(leaf, 5, leaf);
        BinaryTree mediumTree1 = new Node(basicTree2, 4, leaf);
        BinaryTree mediumTree2 = new Node(basicTree1, 2, basicTree1);
        BinaryTree complexTree = new Node(mediumTree2, 3, mediumTree1);

        testEqual(false, isPresent(leaf, 1),         "leaf does not contain 1");

        testEqual(true,  isPresent(basicTree1, 1),   "basicTree1 contains 1");
        testEqual(false, isPresent(basicTree1, 2),   "basicTree1 does not contain 2");

        testEqual(true,  isPresent(basicTree2, 5),   "basicTree2 contains 5");
        testEqual(false, isPresent(basicTree2, 3),   "basicTree2 does not contain 3");

        testEqual(true,  isPresent(mediumTree1, 4),  "mediumTree1 contains 4");
        testEqual(true,  isPresent(mediumTree1, 5),  "mediumTree1 contains 5");
        testEqual(false, isPresent(mediumTree1, 1),  "mediumTree1 does not contain 1");

        testEqual(true,  isPresent(mediumTree2, 2),  "mediumTree2 contains 2");
        testEqual(true,  isPresent(mediumTree2, 1),  "mediumTree2 contains 1");
        testEqual(false, isPresent(mediumTree2, 5),  "mediumTree2 does not contain 5");

        testEqual(true,  isPresent(complexTree, 3),  "complexTree contains 3");
        testEqual(true,  isPresent(complexTree, 5),  "complexTree contains 5");
        testEqual(true,  isPresent(complexTree, 1),  "complexTree contains 1");
        testEqual(false, isPresent(complexTree, 99), "complexTree does not contain 99");
    }

    void testEqual(boolean expected, boolean actual, String label) {
        if (expected == actual) System.out.println("PASS: " + label);
        else System.out.println("FAIL: " + label + " | expected " + expected + " got " + actual);
    }

    public static void main(String[] args) {
        new IsPresent().testExercise3();
    }
}
