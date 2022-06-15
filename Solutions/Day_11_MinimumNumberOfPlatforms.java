import java.util.*;
public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);
        int res=0, i=0, j=0, count=0;
        while(i<n && j<n){
            if(at[i]<=dt[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            res=Math.max(res, count);
        }
        return res;
    }
}