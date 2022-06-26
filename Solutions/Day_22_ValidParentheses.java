import java.util.*;
public class Solution {
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        Stack<Character> stack=new Stack<>();
        for(char ch:expression.toCharArray()){
            if(ch=='{' || ch=='[' || ch=='(')
                stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                char ch1=stack.pop();
                if(ch==')' && ch1!='(') return false;
                if(ch==']' && ch1!='[') return false;
                if(ch=='}' && ch1!='{') return false;
            }
        }
        return stack.isEmpty();
    }
}