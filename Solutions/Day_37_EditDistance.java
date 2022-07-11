// Recursion (TLE)
public class Solution {
    public static int helper(int n, String str1, int m, String str2){
        if(n<0) return m+1;
        if(m<0) return n+1;
        if(str1.charAt(n)==str2.charAt(m))
            return helper(n-1, str1, m-1, str2);
        return 1+Math.min(helper(n-1, str1, m, str2), Math.min(helper(n, str1, m-1, str2), helper(n-1, str1, m-1, str2)));
    }
    public static int editDistance(String str1, String str2) {
        //Your code goes here
        int n=str1.length(), m=str2.length();
        return helper(n-1, str1, m-1, str2);
    }
}


// Memoization (Top - Down)
import java.util.*;
public class Solution {
    public static int helper(int n, String str1, int m, String str2, int[][] dp){
        if(n<0) return m+1;
        if(m<0) return n+1;
        if(dp[n][m]!=-1) return dp[n][m];
        if(str1.charAt(n)==str2.charAt(m))
            return dp[n][m]=helper(n-1, str1, m-1, str2, dp);
        return dp[n][m]=1+Math.min(helper(n-1, str1, m, str2, dp), Math.min(helper(n, str1, m-1, str2, dp), helper(n-1, str1, m-1, str2, dp)));
    }
    public static int editDistance(String str1, String str2) {
        //Your code goes here
        int n=str1.length(), m=str2.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(n-1, str1, m-1, str2, dp);
    }
}


// Tabulation (Bottom Up)
import java.util.*;
public class Solution {
    public static int editDistance(String str1, String str2) {
        //Your code goes here
        int n=str1.length(), m=str2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=m;i++)
            dp[0][i]=i;
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }
        return dp[n][m];
    }
}