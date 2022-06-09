import java.util.*;
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
	}
}