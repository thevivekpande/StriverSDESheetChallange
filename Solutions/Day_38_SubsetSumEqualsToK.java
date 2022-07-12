// Recursion (TLE)
public class Solution {
    public static boolean helper(int ind, int k, int[] arr){
        if(k==0) return true;
        if(ind==0){
            if(k==arr[0]) return true;
            return false;
        }
        boolean notTake=helper(ind-1, k, arr);
        boolean take=false;
        if(k>=arr[ind]) take=helper(ind-1, k-arr[ind], arr);
        return take||notTake;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        return helper(n-1, k, arr);
    }
}
	


// Memoization (Top Down)
import java.util.*;
public class Solution {
    public static boolean helper(int ind, int k, int[] arr, int[][] dp){
        if(k==0) return true;
        if(ind==0){
            if(k==arr[0]) return true;
            return false;
        }
        if(dp[ind][k]!=-1) return dp[ind][k]==1;
        boolean notTake=helper(ind-1, k, arr, dp);
        boolean take=false;
        if(k>=arr[ind]) take=helper(ind-1, k-arr[ind], arr, dp);
        dp[ind][k]=take||notTake?1:0;
        return take||notTake;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp=new int[n+1][k+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(n-1, k, arr, dp);
    }
}



// Tabulation (Bottom Up)
import java.util.*;
public class Solution {
   
    public static boolean subsetSumToK(int n, int k, int[] arr){
        // Write your code here.
        boolean[][] dp=new boolean[n][k+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        for(int i=0;i<=k;i++) if(i==arr[0]) dp[0][i]=true;
        for(int i=1;i<n;i++){
            for(int target=1;target<=k;target++){
                boolean notTake=dp[i-1][target];
                boolean take=false;
                if(target>=arr[i])
                    take=dp[i-1][target-arr[i]];
                    dp[i][target]=(take||notTake);
            }
        }
        return dp[n-1][k];
    }
}
