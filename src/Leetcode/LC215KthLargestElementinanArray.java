package Leetcode;

import java.util.PriorityQueue;

public class LC215KthLargestElementinanArray {

        public int findKthLargest(int[] nums, int k) {

            // use priority queue as it is min-heap (smallest element at the top)
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            // add each element into the priority queue
            for(int num : nums){
                queue.add(num);

            // as we know it is descending order then, if we remove elements beyond index k
            if(queue.size()>k){
                queue.poll();
            }
            }
            // the one on the top which will be the k th the largest number
            return queue.peek();

        }

}
