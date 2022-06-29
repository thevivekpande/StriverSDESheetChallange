/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
import java.util.*;
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
            stack.push(i);
        while(stack.size()>=2){
            int i=stack.pop();
            int j=stack.pop();
            if(Runner.knows(i,j))
                stack.push(j);
            else stack.push(i);
        }
        int pot=stack.pop();
        for(int i=0;i<n;i++){
            if(Runner.knows(pot, i)) return -1;
            if(!Runner.knows(i, pot) && i!=pot) return -1;
        }
        return pot;
    }
}