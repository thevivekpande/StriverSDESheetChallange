import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
    public static void swap(ArrayList<Integer> arr, int i, int j){
        int temp=arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    
    public static void reverse(ArrayList<Integer> arr, int i, int j){
        while(i<j) swap(arr, i++, j--);
    }
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
        if(permutation.size()<=1) return permutation;
        int n=permutation.size()-2;
        while(n>=0 && permutation.get(n)>=permutation.get(n+1)) n--;
        if(n>=0){
            int m=permutation.size()-1;
            while(permutation.get(m)<=permutation.get(n)) m--;
            swap(permutation, n, m);
        }
        reverse(permutation, n+1, permutation.size()-1);
        return permutation;
        
	}
}
