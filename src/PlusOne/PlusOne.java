package PlusOne;

/**
 * Created by namrataojha on 5/12/16.
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Given [1,2,3] which represents 123, return [1,2,4].

 Given [9,9,9] which represents 999, return [1,0,0,0].


 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean flag = true; // flag if the digit needs to be changed

        for (int i = len - 1; i >= 0; i--) {
            if (flag) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    flag = false;
                }

                if (i == 0 && digits[i] == 0) { //index=0
                    int[] y = new int[len + 1];
                    y[0] = 1;
                    for (int j = 1; j <= len; j++) {
                        y[j] = digits[j - 1];
                    }
                    digits = y;
                }
            }
        }

        return digits;
    }

    public static void main(String[] args) {
int [] a = {9,9,9};
        PlusOne p = new PlusOne();
        int[] res= p.plusOne(a);

        for (int i :res){
            System.out.println(i);

        }

    }
}
