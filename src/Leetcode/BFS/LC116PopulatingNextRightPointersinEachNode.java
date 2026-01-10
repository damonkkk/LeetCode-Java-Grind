package Leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC116PopulatingNextRightPointersinEachNode {

    /*
// Definition for a Node.

*/
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {

            // base case, if root is null then return null as the immediate right of root is null
            if(root == null){
                return null;
            }

            // use queue to initialise BFS
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            // loop through all the nodes
            while(!q.isEmpty()){
                //  everytime we only look at one level's nodes, so we need to know the size of the level
                int levelSize = q.size();
                // within a level, get the nodes by left to right order
                for(int i = 0; i<levelSize; i++){
                    // return and remove the left most node
                    Node cur = q.poll();

                    // for the nodes that is not the right most node, we set their next be their immediate right neighbour
                    // if it is the right most node, it will fail the condition below, so we won't set it's next, remain null
                    // there must be this node from the same level still sitting in the queue.
                    if(i<levelSize-1){
                        //use peek() only check the nodes but not removing it from the tree allowing the next iteration of the for loop to poll() it.
                        cur.next = q.peek();
                    }

                    // constructing the tree for left nodes (check all the left nodes)
                    if(cur.left != null ){
                        q.add(cur.left);
                    }
                    // constructing the tree for right nodes (check all the right nodes)
                    if (cur.right != null){
                        q.add(cur.right);
                    }

                }

            }
            // return modified root
            return root;
        }
    }
}
