import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    static boolean binarySearch(ArrayList<ArrayList<Integer>> mat, int row, int low, int high, int target){
        while(low<=high){
            int mid=(low+high)/2;
            if(mat.get(row).get(mid)==target) return true;
            else if(mat.get(row).get(mid)>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
	static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {
		// Write your code here.
        int low=0, high=m-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(mat.get(mid).get(0)<=target && mat.get(mid).get(n-1)>=target){
                return binarySearch(mat, mid, 0, n-1, target);
            }else if(mat.get(mid).get(0)>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
	}
}
