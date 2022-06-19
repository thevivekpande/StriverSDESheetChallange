import java.util.*;
public class Solution {
    public static int chessTournament(int[] positions, int n,  int c) 
	{
        // Write your code here. 
        Arrays.sort(positions);
        int low=1, high=positions[n-1]-positions[0];
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(isPossible(positions, n, c, mid)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }
    
    public static boolean isPossible(int[] positions, int n, int c, int val){
        int count=1, last=positions[0];
        for(int i=1;i<n;i++){
            if((positions[i]-last)>=val){
                last=positions[i];
                count++;
            }
        }
        if(count>=c) return true;
        return false;
    }

}