package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by namrataojha on 6/7/16.
 * Problem
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.

 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 Solution
 First sort the array, then use two pointers sliding to find unique enumerations of two sums

 Complexity O(n^2)
 */
import java.util.*;
public class Solution {


        public List<List<Integer>> threeSum(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> ret = new ArrayList<List<Integer>>(); //ListNode list of is saved
            int n = num.length;

            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && num[i] == num[i - 1]) continue;
                int low = i + 1;
                int high = n - 1;

                while (low < high) {
                    int sum = num[i] + num[low] + num[high];

                    if (sum > 0) {
                        while (high > 0 && num[high] == num[high - 1]) high--;
                        high--;
                    } else if (sum < 0) {
                        while (low < n - 1 && num[low] == num[low + 1]) low++;
                        low++;
                    } else {
                        ret.add(Arrays.asList(num[i], num[low], num[high])); // this is a way to add to list list of
                        while (high > 0 && num[high] == num[high - 1]) high--;
                        high--;
                        while (low < n - 1 && num[low] == num[low + 1]) low++;
                        low++;
                    }
                }
            }
            return ret;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            int[] arr;
            arr = new int[] { -1, 0, 1, 2, -1, -4};
            for (List<Integer> a : s.threeSum(arr)) {
                System.out.println(a);
            }
            arr = new int[] { 0, 0, 0, 0};
            for (List<Integer> a : s.threeSum(arr)) {
                System.out.println(a);
            }

        }
    }


