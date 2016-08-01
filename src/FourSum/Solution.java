package FourSum;

/**
 * Created by namrataojha on 6/7/16.
 * Problem
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

 Note:

 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.

 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 Solution
 Same as 3 sum, one more iteration

 iterate first in [0, length - 3)

 iterate second in [first, length - 2)

 use two pointers sliding to get the smallest in enumeration of two sums
 */
import java.util.*;
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {

        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = num.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > target) {
                        while (l > 0 && num[l] == num[l - 1]) l--;
                        l--;
                    } else if (sum < target) {
                        while (k < n - 1 && num[k] == num[k + 1]) k++;
                        k++;
                    } else {
                        ret.add(Arrays.asList(num[i], num[j], num[k], num[l]));
                        while (l > 0 && num[l] == num[l - 1]) l--;
                        l--;
                        while (k < n - 1 && num[k] == num[k + 1]) k++;
                        k++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr;
        arr = new int[] {1, 1, -1, 0, -1, 0, -2, 2};
        for (List<Integer> a : s.fourSum(arr, 0)) {
            System.out.println(a);
        }
        arr = new int[] {0, 0, 0, 0};
        for (List<Integer> a : s.fourSum(arr, 0)) {
            System.out.println(a);
        }

    }
}
