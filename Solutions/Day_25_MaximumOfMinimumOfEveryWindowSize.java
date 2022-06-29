import java.util.*;
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] left=new int[n+1];
        int[] right=new int[n+1];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && a[stack.peek()]>=a[i])
                stack.pop();
            if(!stack.isEmpty())
                right[i]=stack.peek();
            else right[i]=n;
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[stack.peek()]>=a[i])
                stack.pop();
            if(!stack.isEmpty())
                left[i]=stack.peek();
            else left[i]=-1;
            stack.push(i);
        }
       
        int[] res=new int[n];
        Arrays.fill(res,Integer.MIN_VALUE);
        
        for(int i=0;i<n;i++){
            int len=right[i]-left[i]-1;
            res[len-1]=Math.max(res[len-1], a[i]);
        }
        
        for(int i=n-2;i>=0;i--)
            res[i]=Math.max(res[i], res[i+1]);
        
        return res;
    }
}

