// Recursion (TLE)
public class Solution {
    public static int helper(int[][] grid, int m, int n){
        if(m<0 || n<0) return Integer.MAX_VALUE;
        if(m==0 && n==0) return grid[m][n];
        return grid[m][n]+Math.min(helper(grid, m-1, n), helper(grid, m, n-1));
    }
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int m=grid.length, n=grid[0].length;
        return helper(grid, m-1, n-1);
    }
}


// Memoization (Top Down)
import java.util.*;
public class Solution {
    public static int helper(int[][] grid, int m, int n, int[][] dp){
        if(m<0 || n<0) return Integer.MAX_VALUE;
        if(m==0 && n==0) return grid[m][n];
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]=grid[m][n]+Math.min(helper(grid, m-1, n, dp), helper(grid, m, n-1, dp));
    }
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(grid, m-1, n-1, dp);
    }
}


// Tabulation (Bottom Up)
import java.util.*;
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){ 
                if(i==0 && j==0) dp[i][j]=grid[i][j];
                else{
                    int up=grid[i][j];
                    int left=grid[i][j];
                    if(i>0) up+=dp[i-1][j];
                    else up+=100000000;
                    if(j>0) left+=dp[i][j-1];
                    else left+=100000000;
                    dp[i][j]=Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}