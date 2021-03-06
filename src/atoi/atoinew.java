package atoi;

/**
 * Created by namrataojha on 5/18/16.
 * implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument,
 please click the reload button  to reset your code definition.

 spoilers alert... click to show requirements for atoi.

 Subscribe to see which companies asked this question

 Requirements for atoi:

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class atoinew {
    public int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0'); // important line
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }
    public static void main(String[] args){
        atoinew a = new atoinew();
        String s = "+1";
        System.out.println(a.atoi(s));
        String s1 = "-1   ";
        System.out.println(a.atoi(s1));
        String s2 = "  -0012a42   ";
        System.out.println(a.atoi(s2));
        String s3 = "+-2";
        System.out.println(a.atoi(s3));
        String s4 = "    10522545459";
        System.out.println(a.atoi(s4));


        System.out.println(a.atoi("-2898ab89"));
    }

}
