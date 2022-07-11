// Recursion (TLE)
public class Solution {
    public static int helper(int n, String s, int m, String t){
        if(n<0 || m<0) return 0;
        if(s.charAt(n)==t.charAt(m))
            return 1+helper(n-1, s, m-1, t);
        return Math.max(helper(n-1, s, m, t), helper(n, s, m-1 ,t));
    }
	public static int lcs(String s, String t) {
		//Your code goes here
        int n=s.length(), m=t.length();
        return helper(n-1, s, m-1, t);
    }
}


// Memoization (Top-Down Approach)
import java.util.*;
public class Solution {
    public static int helper(int n, String s, int m, String t, int[][] dp){
        if(n<0 || m<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(s.charAt(n)==t.charAt(m))
            return dp[n][m]=1+helper(n-1, s, m-1, t, dp);
        return dp[n][m]=Math.max(helper(n-1, s, m, t, dp), helper(n, s, m-1 ,t, dp));
    }
	public static int lcs(String s, String t) {
		//Your code goes here
        int n=s.length(), m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(n-1, s, m-1, t, dp);
    }
}


// Tabulation (Bottom-Up Approach)
import java.util.*;
public class Solution {
	public static int lcs(String s, String t) {
		//Your code goes here
        int n=s.length(), m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}
