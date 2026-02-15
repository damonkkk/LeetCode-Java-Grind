package Review.Q7.BinaryTree;

public class Square {


    public BinaryTree square(BinaryTree tree){
        // since Node is a record so we cannot modify the record
        // so we create a new node everytime
        return switch (tree){
            // if it is a leaf we create a new leaf (exact the same)
            case Leaf() -> new Leaf();
            // if it is a node we create a new node with recursively call the square method on the left and right of
            // this node and square the current node value.
            case Node(var l, var v, var r) -> new Node(square(l),v*v,square(r));
        };
    }



}
