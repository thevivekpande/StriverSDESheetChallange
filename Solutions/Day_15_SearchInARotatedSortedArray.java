public class Solution {
    public static int search(int arr[], int key) {
        // Write your code here.
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(arr[mid]==key) return mid;
            if(arr[low]<=arr[mid]){
                //left part is sorted
                if(key>=arr[low] && key<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                //right part is sorted
                if(key>=arr[mid] && key<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}