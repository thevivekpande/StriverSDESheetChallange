import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		// Write your code here.
        int m=str.length(), n=pat.length();
        int p=0, t=0;
        ArrayList<Integer> res=new ArrayList();
        for(int i=0;i<n;i++){
            p+=(int)pat.charAt(i);
            t+=(int)str.charAt(i);
        }
        for(int i=0;i<=m-n;i++){
            if(p==t && pat.equals(str.substring(i, i+n)))
                res.add(i);
            if(i<m-n){
                t+=(int)str.charAt(i+n);
                t-=(int)str.charAt(i);
            }
        }
        return res;
	}
}