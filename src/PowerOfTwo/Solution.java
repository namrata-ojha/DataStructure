package PowerOfTwo;

/**
 * Created by namrataojha on 6/26/16.
 * Problem
 Given an integer, write a function to determine if it is a power of two.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
       System.out.println(sol.isPowerOfTwo(30));
    }
}
