import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        helper(0, n, arr, new ArrayList<>(), res);
        return res;
    }
    public static void helper(int ind, int n, int[] arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList(ds));
        for(int i=ind;i<n;i++){
            if(ind!=i && arr[i]==arr[i-1])  continue;
            ds.add(arr[i]);
            helper(i+1, n, arr, ds, res);
            ds.remove(ds.size()-1);
        }
    }
}