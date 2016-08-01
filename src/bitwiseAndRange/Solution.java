package bitwiseAndRange;

/**
 * Created by namrataojha on 6/7/16.
 * Problem
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.

 Solution
 only possible for the prefix in the binary form, iterate to find prefix

 to understand right shift --http://www.geeksforgeeks.org/bitwise-shift-operators-in-java/


 Note-
 Left Shift Operator-->>(Multiply by 2)
 everytime the left shift is applied to a number , corresponding number is doubled or as if multipled by 2
 Similary if we apply it twice number is multipled by 4 or we can say number is multipled by 2 to power of no. of times left shift is applied
 i.e num = num<< 1 // so if num is 2 o/p will be 4 if num is 4 o/p will 8
 and if num =num<< 2 //so if num is 32 o/p will be 128
 (40<<1) ==2 40*2 =80
 (40<<2) ==2*2 =40*4 =160
 (40<<3)=2*2*2=40*8=320
 (40<<4)=2*2*2*2=40*16=640

 Right Shift operator---(divide by 2)
(40>>1) ==20
 30>>2==15
 20>>3==10
 10>>1==5

 40>>1==2==40/2=20
 40>>2==2*2=40/4=10
 40>>3=2*2*2=40/16=2.5
 Bitwisse Right shift Logical (>>>)
 -1>>>1 == 214748647
 -1>>1==-1


 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (n > m) {
            n >>= 1; // Right shift
            m >>= 1; //Right shift
            count++;
        }
        return (m & n) << (count); // left shift by count
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rangeBitwiseAnd(1, 3));
        System.out.println(s.rangeBitwiseAnd(5, 7));
        System.out.println(s.rangeBitwiseAnd(3, 3));
    }
}
