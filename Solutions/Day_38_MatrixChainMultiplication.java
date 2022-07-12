// Recursion (TLE)
import java.util.*;
public class Solution {
    public static int helper(int[] arr, int i, int j){
        if(i>=j) return 0;
        int res=Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int count=arr[i-1]*arr[k]*arr[j] + helper(arr, i, k) + helper(arr, k+1, j);
            res = Math.min(res, count);
        }
        return res;
    }
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
        return helper(arr, 1, N-1);
	}
}


// Memoization (Top Down)
import java.util.*;
public class Solution {
    public static int helper(int[] arr, int i, int j, int[][] dp){
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int count=arr[i-1]*arr[k]*arr[j] + helper(arr, i, k, dp) + helper(arr, k+1, j, dp);
            res=Math.min(res, count);
        }
        return dp[i][j]=res;
    }
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
        int[][] dp=new int[N+1][N+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(arr, 1, N-1, dp);
	}
}


// Tabulation (Bottom Up)
import java.util.*;
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
        int[][] dp=new int[N+1][N+1];
        for(int l=2;l<N;l++){
            for(int i=1;i<N-l+1;i++){
                int j=i+l-1;
                if(j==N)
                    continue;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int count=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    dp[i][j]=Math.min(dp[i][j], count);
                }
            }
        }
        return dp[1][N-1];
	}
}
