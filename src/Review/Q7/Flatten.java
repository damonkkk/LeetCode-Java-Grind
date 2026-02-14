package Review.Q7;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    public ArrayList<Integer> flatten(BinaryTree tree) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(tree, result);
        return result;
    }


    public void helper(BinaryTree tree, ArrayList<Integer> result){
         switch (tree){
            case Leaf() -> {}
            case Node(var l, var v, var r) -> {
                helper(l,result);
                result.add(v);
                helper(r,result);
            }


        };

    }

    void testExercise4() {
        BinaryTree leaf = new Leaf();
        BinaryTree basicTree1 = new Node(leaf, 1, leaf);
        BinaryTree basicTree2 = new Node(leaf, 5, leaf);
        BinaryTree mediumTree1 = new Node(basicTree2, 4, leaf);
        BinaryTree mediumTree2 = new Node(basicTree1, 2, basicTree1);
        BinaryTree complexTree = new Node(mediumTree2, 3, mediumTree1);

        testEqual(new ArrayList<>(),
                flatten(leaf),
                "leaf flattens to []");

        testEqual(new ArrayList<>(List.of(1)),
                flatten(basicTree1),
                "basicTree1 flattens to [1]");

        testEqual(new ArrayList<>(List.of(5)),
                flatten(basicTree2),
                "basicTree2 flattens to [5]");

        testEqual(new ArrayList<>(List.of(5, 4)),
                flatten(mediumTree1),
                "mediumTree1 flattens to [5, 4]");

        testEqual(new ArrayList<>(List.of(1, 2, 1)),
                flatten(mediumTree2),
                "mediumTree2 flattens to [1, 2, 1]");

        testEqual(new ArrayList<>(List.of(1, 2, 1, 3, 5, 4)),
                flatten(complexTree),
                "complexTree flattens to [1, 2, 1, 3, 5, 4]");
    }

    void testEqual(ArrayList<Integer> expected, ArrayList<Integer> actual, String label) {
        if (expected.equals(actual)) System.out.println("PASS: " + label);
        else System.out.println("FAIL: " + label + " | expected " + expected + " got " + actual);
    }

    public static void main(String[] args) {
        new Flatten().testExercise4();
    }



}
