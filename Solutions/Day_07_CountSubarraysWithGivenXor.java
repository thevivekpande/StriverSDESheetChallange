import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
        int n=arr.size();
        int cpx=0, c=0;
        HashMap<Integer,Integer> map=new HashMap();
        for(int i : arr){
            cpx^=i;
            if(map.get(cpx^x)!=null)
                c+=map.get(cpx^x);
            if(cpx==x)
                c++;
            map.put(cpx, map.getOrDefault(cpx, 0)+1);
        }
        return c;
	}
}