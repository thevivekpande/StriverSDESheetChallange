import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int[] hash=new int[n+1];
        int[] res=new int[2];
        for(int i=0;i<n;i++){
            hash[arr.get(i)]++;
        }
        for(int i=1;i<=n;i++){
            if(hash[i]==0) res[0]=i;
            if(hash[i]==2) res[1]=i;
        }
        return res;
    }
}