import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		//write your code here
        Set<Character> set = new HashSet<>();
        int l=0, n=input.length(), res=0;
        for(int r=0;r<n;r++){
            if(set.contains(input.charAt(r))){
                while(l<r && set.contains(input.charAt(r))){
                    set.remove(input.charAt(l));
                    l++;
                }
            }
            set.add(input.charAt(r));
            res=Math.max(res, r-l+1);
        }
        return res;
	}
}