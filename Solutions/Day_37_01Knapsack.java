// Recursion (TLE)
import java.util.ArrayList;

public class Solution {
    public static int helper(ArrayList<Integer> values, ArrayList<Integer> weights, int ind, int w){
        if(ind<0) return 0;
        if(ind==0 && w>=weights.get(0)) return values.get(0);
        int pick=0, notPick=0;
        notPick=helper(values, weights, ind-1, w);
        if(weights.get(ind)<=w) pick=values.get(ind) + helper(values, weights, ind-1, w-weights.get(ind));
        return Math.max(pick, notPick);
    }
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
        return helper(values, weights, n-1, w);
	}
}


// Memoization (Top-Down Approach)
import java.util.*;
public class Solution {
    public static int helper(ArrayList<Integer> values, ArrayList<Integer> weights, int ind, int w, int[][] dp){
        if(ind==0){
            if(w>=weights.get(0)) return values.get(0);
            else return 0;
        }
        if(dp[ind][w]!=-1) return dp[ind][w];
        int notPick=helper(values, weights, ind-1, w, dp);
        int pick=0;
        if(weights.get(ind)<=w) pick=values.get(ind) + helper(values, weights, ind-1, w-weights.get(ind), dp);
        return dp[ind][w]=Math.max(pick, notPick);
    }
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
        int[][] dp=new int[n+1][w+1];
        for(int[] row:dp)
        Arrays.fill(row, -1);
        return helper(values, weights, n-1, w, dp);
	}
}

// Tabulation (Bottom-Up Approach)
import java.util.*;
public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
        int[][] dp=new int[n][w+1];
        for(int i=weights.get(0);i<=w;i++)
            dp[0][i]=values.get(0);
        for(int i=1;i<n;i++){
            for(int wt=0;wt<=w;wt++){
                int notPick=dp[i-1][wt];
                int pick=0;
                if(weights.get(i)<=wt) pick=values.get(i) + dp[i-1][wt-weights.get(i)];
                dp[i][wt]=Math.max(pick, notPick);
            }
        }
        return dp[n-1][w];
	}
}
