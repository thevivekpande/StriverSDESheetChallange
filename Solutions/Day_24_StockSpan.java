import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        ArrayList<Integer> res=new ArrayList();
        Stack<Integer> stack=new Stack();
        int n=price.size();
        for(int i=0;i<n;i++){
            int span=1;
            while(!stack.isEmpty() && price.get(i)>=price.get(stack.peek()))
                span+=res.get(stack.pop());
            stack.push(i);
            res.add(span);
        }
        return res;
    }
}