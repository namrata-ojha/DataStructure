package RandomNumberFromDifferentPositions;

import RandomNumberGenerator.UniqueRandomNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by namrataojha on 6/16/16.
 */
public class RandomNumber {
    public int[] random(int[] a, int m) {
        List<Integer> intList = new ArrayList<Integer>(a.length);
        int[] result = new int[m];
        //adding array elements to list
        for (int i = 0; i < a.length; i++) {
            intList.add(a[i]);
        }
        // shuffle the list
        Collections.shuffle(intList);
        // print the number of elements required
        if (m > intList.size()) {
            int n = m - intList.size();
            System.out.println("Number of elements expected are more than the size of array by : " + (n));
        } else {
            for (int i = 0; i < m; i++) {
                System.out.println(intList.get(i));
                result[i] = intList.get(i);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        RandomNumber u = new RandomNumber();
        int[] a = {1, 3, 4, 6, 9, 0, 2};
        u.random(a, 4);
    }
}
