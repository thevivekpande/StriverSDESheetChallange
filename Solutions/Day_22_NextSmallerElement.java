import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
            res.add(-1);
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()>=arr.get(i))
                stack.pop();
            if(!stack.isEmpty()) res.set(i, stack.peek());
            stack.push(arr.get(i));
        }
        return res;
    }
}