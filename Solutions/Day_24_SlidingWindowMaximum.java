
import java.util.*;
public class Solution 
{
	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
		//	  Write your code here.
        ArrayList<Integer> res=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.size();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peek()==i-k)
                dq.poll();
            while(!dq.isEmpty() && nums.get(dq.peekLast())<=nums.get(i))
                dq.pollLast();
            dq.offer(i);
            if(i>=k-1)
                res.add(nums.get(dq.peek()));
        }
        return res;
	}
}