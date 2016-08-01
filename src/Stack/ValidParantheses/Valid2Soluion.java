package Stack.ValidParantheses;

import java.util.Stack;

/**
 * Created by namrataojha on 5/23/16.
 */
public class Valid2Soluion {


        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                if(a == '(' || a == '[' || a == '{') stack.push(a);
                else if(stack.empty()) return false;
                else if(a == ')' && stack.pop() != '(') return false;
                else if(a == ']' && stack.pop() != '[') return false;
                else if(a == '}' && stack.pop() != '{') return false;
            }
            return stack.empty();
        }

    public static void main(String[] args) {
        Valid2Soluion sol = new Valid2Soluion();
//        System.out.println(sol.isValid(")()())"));
//        System.out.println(sol.isValid("((()"));
//        System.out.println(sol.isValid("((()()()"));
        System.out.println(sol.isValid("((()()()))"));
    }
}
