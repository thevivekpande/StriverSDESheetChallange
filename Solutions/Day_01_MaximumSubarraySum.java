import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
        long maxSum = 0;
        long curSum =0;
        for(int i:arr){
            curSum+=i;
            maxSum=Math.max(curSum, maxSum);
            if(curSum<0) curSum =0;
        }
        return maxSum;
	}

}
