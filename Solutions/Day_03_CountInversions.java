import java.util.* ;
import java.io.*; 
public class Solution {
    public static long merge(long[] arr, long[] temp, int left, int mid, int right){
        long count=0;
        int i=left, j=mid, k=left;
        while((i<=mid-1) && (j<=right)){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
                count+=mid-i;
            }
        }
        
        while(i<=mid-1)
            temp[k++]=arr[i++];
        while(j<=right)
            temp[k++]=arr[j++];
        for(i=left;i<=right;i++)
            arr[i]=temp[i];
        return count;
    }
    public static long mergeSort(long[] arr, long[] temp, int left, int right){
        long count=0;
        if(right>left){
            int mid=(left+right)/2;
            count+=mergeSort(arr, temp, left, mid);
            count+=mergeSort(arr, temp, mid+1, right);
            count+=merge(arr, temp, left, mid+1, right);
        }
        return count;
    }
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long[] temp=new long[n];
        return mergeSort(arr,temp, 0, n-1);
    }
}