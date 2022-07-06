import java.util.*;

public class Solution {
	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
		// Write your code here
        int n=arr.size();
        ArrayList<Integer> res=new ArrayList();
        HashMap<Integer, Integer> map=new HashMap();
        
        for(int i=0;i<k;i++)
            map.put(arr.get(i), map.getOrDefault(arr.get(i),0)+1);
        res.add(map.size());
        
        for(int i=k;i<n;i++){
            if(map.get(arr.get(i-k))==1)
                map.remove(arr.get(i-k));
            
            else
                map.put(arr.get(i-k), map.get(arr.get(i-k))-1);
            
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0)+1);
            res.add(map.size());
        }
        
        return res;
	}
}
