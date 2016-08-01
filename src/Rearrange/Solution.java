package Rearrange;

/**
 * Created by namrataojha on 6/3/16.
 * Check wheather the array can be sorted in one swap
 */
public class Solution {
    public static int sol(int[]data, int n){
        int max = data[0], maxIndex = 0;

        //find the maximum element in the array
        for(int i=0;i<data.length;i++)
        {
            if(data[i] > max)
            {
                max = data[i];
                maxIndex = i;
            }
        }

        //check whether all the elements before max are less than it
        // if not you need more swaps to sort
        for(int j=0;j<maxIndex;j++)
        {
            if(data[j]>max)
                return 0;
        }


        //check what is next smallest element
        for(int j=maxIndex+1;j<data.length-1;j++)
        {
            if(!(max > data[j] && data[j+1] <data[j]))
                return 0;
        }

        return 1;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2,5, 3, 3 };
        Solution s = new Solution();


        System.out.println(s.sol(arr,5));
    }
}
