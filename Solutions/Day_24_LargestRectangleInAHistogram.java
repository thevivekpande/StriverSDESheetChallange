import java.util.*;
public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    // Write your code here.
      int n=heights.size();
      int[] left=new int[n];
      int[] right=new int[n];
      Stack<Integer> stack=new Stack<>();
      for(int i=0;i<n;i++){
          while(!stack.isEmpty() && heights.get(stack.peek())>=heights.get(i))
              stack.pop();
          if(!stack.isEmpty()) left[i]=stack.peek();
          else left[i]=-1;
          stack.push(i);
      }
      stack.clear();
      for(int i=n-1;i>=0;i--){
          while(!stack.isEmpty() && heights.get(stack.peek())>=heights.get(i))
              stack.pop();
          if(!stack.isEmpty()) right[i]=stack.peek();
          else right[i]=n;
          stack.push(i);
      }
      int res=0;
      for(int i=0;i<n;i++)
          res=Math.max(res, (heights.get(i) * (right[i]-left[i]-1)));
      return res;
  }
}