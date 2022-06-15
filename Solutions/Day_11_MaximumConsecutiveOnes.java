import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		// Write your code here.
        int res=0, c=0, l=0;
        for(int i=0;i<n;i++){
            if(arr.get(i)==0) c++;
            while(c>k){
                if(arr.get(l)==0)
                    c--;
                l++;
            }
            res=Math.max(res, i-l+1);
        }
        return res;
	}
}