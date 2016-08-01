package ThreeSumClosest;

/**
 * Created by namrataojha on 6/7/16.
 *
 * Problem
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 Solution
 Same as 3 sum. Complexity O(n^2)

 sort the array

 iterate first selection in [0, length - 2)

 use two pointers sliding to find the smallest in the enumerations of two sums
 */
import java.util.*;
public class Solution {
    public int threeSumClosest(int[] num, int target) {

        Arrays.sort(num);
        int result = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < num.length - 2; i++) {
            int low = i + 1;
            int high = num.length - 1;
            while (low < high) {
                int curr = num[i] + num[low] + num[high];
                int dist = Math.abs(curr - target);
                if (dist < minDist) {
                    minDist = dist;
                    result = curr;
                }
                if (curr > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { -1, 2, 1, -4};
        int target = 1;
        System.out.println(s.threeSumClosest(arr, 1));
    }
}
