import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
        int l1=m-1, l2=n-1,f1=m+n-1;
        while(l1>=0 && l2>=0)
            arr1[f1--]=(arr1[l1]>=arr2[l2])?arr1[l1--]:arr2[l2--];
        
        while(l2>=0)
            arr1[f1--]=arr2[l2--];
        return arr1;
    }
}
