// Recursion (TLE)
public class Solution {
    public static int helper(int[] price, int ind, int size){
        if(size==0) return 0;
        if(ind==1){
            return price[0]*size;
        }
        int notTake=helper(price, ind-1, size);
        int take=0;
        if(size>=ind) take=price[ind-1]+helper(price, ind, size-ind);
        return Math.max(take, notTake);
    }
	public static int cutRod(int price[], int n) {
		// Write your code here.
        return helper(price, n, n);
	}
}
	


// Memoization (Top Down)
import java.util.*;
public class Solution {
    public static int helper(int[] price, int ind, int size, int[][] dp){
        if(size==0) return 0;
        if(ind==1){
            return price[0]*size;
        }
        if(dp[ind][size]!=-1) return dp[ind][size];
        int notTake=helper(price, ind-1, size, dp);
        int take=0;
        if(size>=ind) take=price[ind-1]+helper(price, ind, size-ind, dp);
        return dp[ind][size] = Math.max(take, notTake);
    }
	public static int cutRod(int price[], int n) {
		// Write your code here.
        int[][] dp=new int[n+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(price, n, n, dp);
	}
}



// Tabulation (Bottom Up)
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            dp[1][i]=price[0]*i;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=n;j++){
                int notTake=dp[i-1][j];
                int take=0;
                if(j>=i) take=price[i-1]+dp[i][j-i];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n][n];
	}
}
