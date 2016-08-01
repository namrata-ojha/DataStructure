package RandomNumbers2;

import java.util.LinkedHashSet;
import java.util.*;

/**
 * Created by namrataojha on 6/16/16.
 */
public class RandomNo {

    static int[] UniqueRandomNo(int m ,int n){
        int[] result = new int[m];
        if(m>n) {
            System.out.println("No of elements expected  m is more than the maximum value N");
            return result;
        }
        Set<Integer> resultSet = new LinkedHashSet<Integer>();

        int i =0;
        Random rng = new Random();
        while (resultSet.size() < m)
        {
            Integer next = rng.nextInt(n) + 1; // Generate random value less than or equal to n
            // As we're adding to result set, this will automatically do result containment check
            resultSet.add(next);

        }
        for (Integer myVal : resultSet) { // Copy the results in array
            result[i++]=myVal;

        }
        return result;
    }

    public static void main(String[] args) {
        RandomNo u = new RandomNo();


        for (int i :u.UniqueRandomNo(40,50)) {
            System.out.println(i);
        }
    }
}
