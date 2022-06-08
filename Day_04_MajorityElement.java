import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
        int res=-1, count=0;
        for(int a : arr){
            if(count==0)
                res=a;
            if(a==res) count++;
            else count--;
        }
        count=0;
        for(int a:arr){
            if(a==res) count++;
        }
        return count>(n/2)?res:-1;
	}
}