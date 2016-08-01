package RandomNumberFromArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 *
 * Program Doesn't work properly
 */
public class RandomNumberNew {
    public int[] random(int[] a,int m) {
        HashMap<Integer,Integer> intList = new HashMap<Integer,Integer>();
        int[] result = new int[m];

        //System.out.println(a[index]);


        if (m > a.length) {
            int n = m - intList.size();
            System.out.println("Number of elements are more than the size of array by : " + (n));
        } else {
            for (int i = 0; i < m; i++) {
                Random random = new Random();
                int index = random.nextInt(a.length);
                if (!intList.containsKey(index)) {
                    intList.put(index, a[i]);

                    //System.out.println(intList.get(i));
                    result[i] = intList.get(index);
                }
            }
            for(int i=0 ;i<result.length;i++){
                System.out.println(result[i]);
            }
        }



        return result;
    }
    public static void main(String[] args) {
        RandomNumberNew r = new RandomNumberNew();
        int[] a= {1,3,4,6,9,0,2};
         r.random(a,7);

       // r.random(a,4);
    }
}
