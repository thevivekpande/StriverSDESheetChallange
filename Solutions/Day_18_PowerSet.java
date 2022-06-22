import java.util.*;
public class Solution {
    public static void helper(int ind, int n, ArrayList<Integer> arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res){
        if(ind==n){
            res.add(new ArrayList(ds));
            return;
        }
        
        ds.add(arr.get(ind));
        helper(ind+1, n, arr, ds, res);
        ds.remove(ds.size()-1);
        helper(ind+1, n, arr, ds, res);
    }
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		// WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        int n=arr.size();
        helper(0, n, arr, new ArrayList(), res);
        return res;
	}
}

