import java.util.*;
public class Solution {
    public static void swap(char[] str, int i, int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }
    public static void helper(int ind, int n, char[] str, List<String> res){
        if(ind==n){
            String s=new String(str);
            res.add(s);
        }
        for(int i=ind;i<n;i++){
            swap(str, i, ind);
            helper(ind+1, n, str, res);
            swap(str, i, ind);
        }
    }
    public static List<String> findPermutations(String s) {
        // Write your code here.
        List<String> res=new ArrayList();
        helper(0, s.length(), s.toCharArray(), res);
        return res;
    }
}