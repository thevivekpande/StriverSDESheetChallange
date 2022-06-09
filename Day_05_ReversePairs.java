import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static int merge(ArrayList<Integer> arr, int low, int high, int mid){
        int i=0, j=mid+1, cnt=0;
        for(i=low;i<=mid;i++){
            while(j<=high && arr.get(i)>(2*(long)arr.get(j)))
                j++;
            cnt+=j-(mid+1);
        }
        
        ArrayList<Integer> temp=new ArrayList<>();
        i=low;
        j=mid+1;
        while(i<=mid && j<=high){
            if(arr.get(i)<=arr.get(j))
                temp.add(arr.get(i++));
            else temp.add(arr.get(j++));
        }
        while(j<=high) temp.add(arr.get(j++));
        while(i<=mid) temp.add(arr.get(i++));
        for(i=low;i<=high;i++)
            arr.set(i, temp.get(i-low));
        return cnt;
    }
    public static int mergeSort(ArrayList<Integer> arr, int low, int high){
        if(low>=high) return 0;
        int mid=(low+high)/2;
        int invCnt = mergeSort(arr, low, mid);
        invCnt += mergeSort(arr, mid+1, high);
        invCnt += merge(arr, low, high, mid);
        return invCnt;
    }
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        // Write your code here.
        int high=arr.size()-1, low=0;
        return mergeSort(arr, low, high);
    }
}