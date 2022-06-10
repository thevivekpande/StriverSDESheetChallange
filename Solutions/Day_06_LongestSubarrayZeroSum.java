import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Write your code here.
        HashMap<Integer, Integer> map=new HashMap();
        int res=0, sum=0, n=arr.size();
        for(int i=0;i<n;i++){
            sum+=arr.get(i);
            if(sum==0) res=i+1;
            else{
                if(map.get(sum)!=null){
                    res=Math.max(res,i - map.get(sum));
                }else{
                    map.put(sum, i);
                }
            }
        }
        return res;
	}
}