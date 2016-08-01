package HappyNumber;

import java.util.HashSet;

/**
 * Created by namrataojha on 5/18/16.
 * Problem
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process:
 Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 (where it will stay),or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1

 Solution
 hashset
 */
public class HappyNum {

        //public static boolean happy(long number){
            public static boolean isHappy(int n) {
                HashSet<Integer> set = new HashSet<Integer>();

                while(!set.contains(n)){
                    set.add(n);

                    n = sum(getDigits(n));
                    if (n == 1)
                        return true;
                }

                return false;
            }

            public static int sum(int[] arr){
                int sum = 0;
                for(int i: arr){
                    sum = sum + i*i;
                }
                return sum;
            }

            public static int[] getDigits(int n){
                String s = String.valueOf(n);
                int[] result = new int[s.length()];
                int i=0;

                while(n>0){
                    int m = n%10;
                    result[i++] = m;
                    n = n/10;
                }

                return result;
            }


        public static void main(String[] args){
          //  for(long num = 1,count = 0;count<8;num++){
              //  isHappy(100)
                    System.out.println( isHappy(19));
//                    count++;
//                }
            }
        }



