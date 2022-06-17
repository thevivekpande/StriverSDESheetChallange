import java.util.*;

public class Solution 
{
    public static void helper(int ind, int n, int target, int sum, ArrayList<Integer> arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res){
        if(sum==target)
            res.add(new ArrayList(ds));
        for(int i=ind;i<n;i++){
            if(i!=ind && arr.get(i)==arr.get(i-1)) continue;
            ds.add(arr.get(i));
            helper(i+1, n, target, sum+arr.get(i), arr, ds, res);
            ds.remove(ds.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        //    Write your code here.
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        Collections.sort(arr);
        helper(0, n, target, 0, arr, new ArrayList(), res);
        return res;
    }
}