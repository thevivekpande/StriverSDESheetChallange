// Recursion (TLE)
public class Solution {
    public static long helper(int[] denominations, int ind, int value){
        if(value==0) return 1;
        if(ind==0){
            if(value%denominations[0]==0) return 1;
            return 0;
        }
        long notTake=helper(denominations, ind-1, value);
        long take=0;
        if(value>=denominations[ind]) take=helper(denominations, ind,  value-denominations[ind]);
        return take+notTake;
    }
	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here			
        int n=denominations.length;
        return helper(denominations, n-1, value);
	}
	
}


// Memoization (Top Down)
import java.util.*;
public class Solution {
    public static long helper(int[] denominations, int ind, int value, long[][] dp){
        if(value==0) return 1;
        if(ind==0){
            if(value%denominations[0]==0) return 1;
            return 0;
        }
        if(dp[value][ind]!=-1) return dp[value][ind];
        long notTake=helper(denominations, ind-1, value, dp);
        long take=0;
        if(value>=denominations[ind]) take=helper(denominations, ind,  value-denominations[ind], dp);
        return dp[value][ind]=take+notTake;
    }
	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here			
        int n=denominations.length;
        long[][] dp=new long[value+1][n+1];
        for(long[] row:dp)
            Arrays.fill(row, -1);
        return helper(denominations, n-1, value, dp);
	}
	
}


// Tabulation (Bottom Up)
public class Solution {
	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here			
        int n=denominations.length;
        long[][] dp=new long[value+1][n+1];
        for(int i=0;i<=value;i++)
            if(i%denominations[0]==0) dp[i][0]=1;
        for(int i=0;i<n;i++)
            dp[0][i]=1;
        for(int i=1;i<=value;i++){
            for(int j=1;j<n;j++){
                long notTake=dp[i][j-1];
                long take=0;
                if(i>=denominations[j]) take=dp[i-denominations[j]][j];
                dp[i][j]=take+notTake;
            }
        }
        return dp[value][n-1];
	}
}