import java.util.*;
public class Solution 
{
    public static void helper(int ind, int n, int k, int sum, ArrayList<Integer> arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res){
        if(sum==k)
            res.add(new ArrayList(ds));
        for(int i=ind;i<n;i++){
            ds.add(arr.get(i));
            helper(i+1, n, k, sum+arr.get(i), arr, ds, res);
            ds.remove(ds.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        // Write your code here.
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        helper(0, n, k, 0, arr, new ArrayList(), res);
        return res;
    }
}