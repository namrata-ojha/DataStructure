package Rearrange;

import java.util.Arrays;

/**
 * Created by namrataojha on 6/5/16.
 */
public class Sol2 {

    public static int sol(int[]data, int n){
        int[] copied = new int[n];
        System.arraycopy(data, 0, copied, 0, data.length);//5 is the length to copy
        Arrays.sort(data);
        int count=0;
        for(int i =0 ;i<data.length;i++){
            if(data[i]!=copied[i])
                count++;
        }
        if (count>2) return 1;
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 4,5, 3, 3 };
        Sol2 s = new Sol2();


        System.out.println(s.sol(arr,5));
    }
}
