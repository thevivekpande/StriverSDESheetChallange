import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        int hash[]=new int[n];
        for(int i=0;i<n;i++)
            if(hash[arr.get(i)]==0)
                hash[arr.get(i)]++;
            else return arr.get(i);
        return -1;
    }
}
