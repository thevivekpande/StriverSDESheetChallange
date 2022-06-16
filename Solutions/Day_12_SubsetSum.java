import java.util.*;
public class Solution {
    public static void helper(int ind, int n, int[] nums, ArrayList<Integer> res, int sum){
        if(n==ind){
            res.add(sum);
            return;
        }
        helper(ind+1, n, nums, res, sum);
        helper(ind+1, n, nums, res, sum+nums[ind]);
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> res=new ArrayList<>();
        int n=num.length;
        helper(0, n, num, res, 0);
        Collections.sort(res);
        return res;
    }
}