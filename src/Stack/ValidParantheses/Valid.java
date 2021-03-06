package Stack.ValidParantheses;

import java.util.Stack;

/**
 * Created by namrataojha on 5/23/16.
 */
public class Valid {

        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<Integer>();
            int ret = -1;
            for (int right = 0; right < s.length(); ++right) {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(' && s.charAt(right) == ')') {
                    stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    ret = Math.max(ret, right - left);
                } else {
                    stack.push(right);
                }
            }
            return ret;
        }
        public static void main(String[] args) {
            Valid sol = new Valid();
            System.out.println(sol.longestValidParentheses("())"));
            System.out.println(sol.longestValidParentheses("((()"));
            System.out.println(sol.longestValidParentheses("((()()()"));
            System.out.println(sol.longestValidParentheses("((()()()))"));
        }

}
