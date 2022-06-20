import java.util.*;
public class Solution {
	public static int[] KMostFrequent(int n, int k, int[] arr) {
		// Write your code here.
        HashMap<Integer, Integer> map=new HashMap();
        for(int i:arr)
            map.put(i, map.getOrDefault(i,0)+1);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        
        for(int i:map.keySet()){
            pq.add(i);
            if(pq.size()>k)
                pq.remove();
        }
        
        int[] res = new int[k];
        for(int i=0;i<k;i++)
            res[i]=pq.remove();
        
        return res;
	}

}
