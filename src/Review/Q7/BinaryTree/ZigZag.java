package Review.Q7.BinaryTree;

import java.util.ArrayList;

public class ZigZag {

    public ArrayList<Integer> ZigZag(BinaryTree tree){
        // create a list of integer to store the result
        ArrayList<Integer> result = new ArrayList<>();
        // call the helper function to actually do the zigzag logic
        helper(result,tree,true);
        // return the zigzag list
        return result;
    }



    public void helper(ArrayList<Integer> res,BinaryTree tree, boolean zigzag ){
        // logic: switch
        switch (tree) {
            // if it is a leaf we do nothing
            case Leaf() -> {}
            // if it is a node we
            case Node(BinaryTree left, int value, BinaryTree right) -> {
                // we add the current node value first,
                // if zigzag is true we go left first, then set zigzag as false so next round we can go right
                res.add(value);
                if(zigzag) {
                    helper(res, left, !zigzag);
                } else {
                helper(res, right, !zigzag);}
            }

        };
    }
}
