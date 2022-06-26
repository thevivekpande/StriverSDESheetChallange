import java.util.*;
public class Solution {
    public static void sort(Stack<Integer> stack, int x){
        if(stack.isEmpty() || (!stack.isEmpty() && x>stack.peek())){
            stack.push(x);
            return;
        }
        int n=stack.pop();
        sort(stack, x);
        stack.push(n);
    }
	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        if(stack.isEmpty()) return;
        int x=stack.pop();
        sortStack(stack);
        sort(stack, x);
	}

}