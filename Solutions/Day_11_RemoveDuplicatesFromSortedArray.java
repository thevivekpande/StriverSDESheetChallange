import java.util.*;
public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		// Write your code here.
        int i=0, j=1;
        arr.set(i,arr.get(0));
        for(j=1;j<n;j++){
            if(arr.get(i)!=arr.get(j))
                arr.set(++i,arr.get(j));
        }
        return i+1;
	}
}