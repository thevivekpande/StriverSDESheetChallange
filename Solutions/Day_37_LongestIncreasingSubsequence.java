// Using DP(n^2) TLE
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
        int n=arr.length;
        int[] dp=new int[n];
        int res=1;
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                    res=Math.max(res, dp[i]);
                }
            }
        }
        return res;
	}

}


// Using Binary Search O(nlogn)
public class Solution {
    static int ceil(int[] arr, int l, int h, int x){
        while(h>l+1){
            int m=l+((h-l)>>1);
            if(arr[m]>=x) h=m;
            else l=m;
        }
        return h;
    } 
	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
        int size=arr.length;
        int[] lis=new int[size+1];
        int len=1;
        lis[0]=arr[0];
        for(int i=1;i<size;i++){
            if(arr[i]<lis[0]) lis[0]=arr[i];
            else if(arr[i]>lis[len-1]){
                lis[len]=arr[i];
                len++;
            }else{
                int c=ceil(lis, 0, len-1, arr[i]);
                lis[c]=arr[i];
            }
        }
        return len;
	}

}