import java.util.*;
public class Solution { 
    public static boolean isPalindrome(String str, int start, int end){
        while(start<=end){
            if(str.charAt(start++)!=str.charAt(end--))
                return false;
        }
        return true;
    }
    
    public static void helper(int ind, int n, String s, List<String> ds, List<List<String>> res){
        if(ind==n)
            res.add(new ArrayList<>(ds));
        for(int i=ind;i<n;i++){
            if(isPalindrome(s, ind, i)){
                ds.add(s.substring(ind, i+1));
                helper(i+1, n, s, ds, res);
                ds.remove(ds.size()-1);
            }
        }
    }
    public static List<List<String>> partition(String s) {
        // Write your code here.
        List<List<String>> res=new ArrayList<>();
        helper(0, s.length(), s, new ArrayList(), res);
        return res;
    }
}