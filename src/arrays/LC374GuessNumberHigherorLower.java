package arrays;

public class LC374GuessNumberHigherorLower {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */


    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            //start of the range
            int low = 0;
            // end of the range
            int high = n;

            int mid = 0;

            while (low <= high) {
                //calculate the midpoint = low +(high - low )/2  to prevent overflow
                mid = low + (high - low) / 2;
                // return mid as we guess it right
                if (guess(mid) == 0)
                    return mid;
                // the number is smaller, update high = mid -1
                if (guess(mid) == -1)
                    high = mid - 1;
                // the number is larger, update low = mid + 1
                if (guess(mid) == 1)
                    low = mid + 1;
            }

            //If no number is found (though constraints guarantee a solution), return -1.
            return -1;
        }
    }
}
