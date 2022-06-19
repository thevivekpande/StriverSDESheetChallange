public class Solution {
    public static boolean isPossible(int[] time, int n, long val){
        long count=0, sum=0;
        for(int i: time){
            if(sum+i>val){
                sum=i;
                count++;
                if(count>n || sum>val) return false;
            }else{
                sum+=i;
            }
        }
        if(count<n) return true;
        return false;
    }
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // Write your code here.
        if(time.length<n) return -1;
        long low=0, high=0;
        for(int i: time){
            low=Math.min(low, i);
            high+=i;
        }
        while(low<=high){
            long mid=low+((high-low)>>1);
            if(isPossible(time, n, mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}