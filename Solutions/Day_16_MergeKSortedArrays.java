import java.util.*;
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        ArrayList<Integer> res=new ArrayList();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(ArrayList<Integer> row:kArrays)
            for(Integer num: row)
                pq.add(num);

        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        
        return res;
	}
}
