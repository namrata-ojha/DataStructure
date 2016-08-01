package RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by namrataojha on 6/14/16.
 * Time complexity increases if no. of elements are more in array i.e m is large
 */
public class UniqueRandomNumber {


    static void UniqueRandomNo(int m ,int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<m+1; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<n; i++) {
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args) {
        UniqueRandomNumber u = new UniqueRandomNumber();
         u.UniqueRandomNo(10,5);
    }
}
