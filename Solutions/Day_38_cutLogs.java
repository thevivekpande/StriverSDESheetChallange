// Recursion (TLE)
import java.util.*;
public class Solution {
    public static int helper(int k, int n){
        if(k==1 || n==0 || n==1) return n;
        
        int res=Integer.MAX_VALUE;
        int l=1, h=n;
        
        while(l<=h){
            int mid = l + ((h-l)>>2);
            int below=helper(k-1 , mid-1);
            int above=helper(k , n-mid);
            int count = 1+Math.max(above,below);
            if(above>below)
                l=mid+1;
            else
                h=mid-1;
            res = Math.min(res , count);
        }

        return res;
    }
    public static int cutLogs(int k, int n) {
        //Write your code here
        return helper(k, n);
    }
}


// Memoization (Top Down)
import java.util.*;
public class Solution {
    public static int helper(int k, int n, int[][] dp){
        if(k==1 || n==0 || n==1) return n;
        if(dp[k][n]!=-1) return dp[k][n];
        
        int res=Integer.MAX_VALUE;
        int l=1, h=n;
        
        while(l<=h){
            int mid = l + ((h-l)>>2);
            int below=helper(k-1 , mid-1, dp);
            int above=helper(k , n-mid, dp);
            int count = 1+Math.max(above,below);
            if(above>below)
                l=mid+1;
            else
                h=mid-1;
            res = Math.min(res , count);
        }

        return dp[k][n]=res;
    }
    public static int cutLogs(int k, int n) {
        //Write your code here
        int[][] dp=new int[k+1][n+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(k, n, dp);
    }
}
