// Recursion
public class Solution {
    public static boolean isPalindrome(String str){
        int l=0, r=str.length()-1;
        while(l<=r){
            if(str.charAt(l)!=(str.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
    public static int helper(String str, int i, int j){
        if(i>=j || isPalindrome(str.substring(i, j+1))) return 0;
        int res=100;
        for(int k=i;k<j;k++){
            if(isPalindrome(str.substring(i, k+1))){
                int count=1+helper(str, k+1, j);
                res=Math.min(res, count);
            }
        }
        return res;
    }
	public static int palindromePartitioning(String str) {
	    // Write your code here
        return helper(str, 0, str.length()-1);
	}
}


// Memoization
import java.util.*;
public class Solution {
    public static boolean isPalindrome(String str){
        int l=0, r=str.length()-1;
        while(l<r){
            if(str.charAt(l)!=(str.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
    public static int helper(String str, int i, int j, int[] dp){
        if(i>=j || isPalindrome(str.substring(i, j+1))) return 0;
        if(dp[i]!=-1) return dp[i];
        int res=100;
        for(int k=i;k<j;k++){
            if(isPalindrome(str.substring(i, k+1))){
                int count=1+helper(str, k+1, j, dp);
                res=Math.min(res, count);
            }
        }
        return dp[i]=res;
    }
	public static int palindromePartitioning(String str) {
	    // Write your code here
        int[] dp=new int[str.length()+1];
        Arrays.fill(dp,-1);
        return helper(str, 0, str.length()-1, dp);
	}
}

