import java.util.*;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
        HashSet<String> set=new HashSet<>(dictionary);
        return dfs(s, 0, set);
	}
    public static ArrayList<String> dfs(String s, int start, HashSet<String> dict){
        ArrayList<String> res=new ArrayList();
        if(start==s.length())
            res.add("");
        for(int end=start+1;end<=s.length();end++){
            String prefix=s.substring(start, end);
            if(dict.contains(prefix)){
                ArrayList<String> suffixes=dfs(s, end,dict);
                for(String suffix:suffixes)
                    res.add(prefix+(suffix.equals("")?"":" ")+suffix);
            }
        }
        return res;
    }
}