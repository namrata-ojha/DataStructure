package RemoveDuplicatesFromSortedArray;

import RemoveElement.RemoveElement;

import java.util.Arrays;

/**
 * Created by namrataojha on 5/12/16.
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. Do not allocate extra space for another array, you must do this in place with constant memory.

 For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].


 */
public class Solution {
    // Create an array with all unique elements
    public static int[] removeDuplicates(int[] A) {
        if (A.length < 2)
            return A;

        int j = 0;
        int i = 1;

        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }

        int[] B = Arrays.copyOf(A, j + 1);

        return B;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2,2, 3, 3 };
        arr = removeDuplicates(arr);
        System.out.println(arr.length);
    }

}
