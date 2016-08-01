package BinaryTree.LongestCommonPrefix;

/**
 * Created by namrataojha on 6/7/16.
 * Problem
 Longest Common Prefix Write a function to find the longest common prefix string amongst an array of strings.

 Solution
 Find common prefix of two strs, then reduce the function to the whole list
 Status API Training Shop Blog About

 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = prefix(result, strs[i]);
        }
        return result;
    }
    public String prefix(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        int i = 0;
        for (; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) break;
        }
        return s1.substring(0, i);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] list = new String[] {"aaa", "aab", "abb"};
        String result = s.longestCommonPrefix(list);
        System.out.println(result);
    }
}
