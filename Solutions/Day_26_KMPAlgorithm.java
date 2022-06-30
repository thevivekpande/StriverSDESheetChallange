// #M1 Using Robin Karp Algo
public class Solution {
    public static boolean findPattern(String p, String s) {
        // Write your code here.
        int pat=0, tex=0;
        int m=p.length(), n=s.length();
        for(int i=0;i<m;i++){
            pat+=(int)p.charAt(i);
            tex+=(int)s.charAt(i);
        }
        for(int i=0;i<=n-m;i++){
            if(pat==tex && p.equals(s.substring(i, i+m)))
                return true;
            if(i<n-m){
                tex+=(int)s.charAt(i+m);
                tex-=(int)s.charAt(i);
            }
        }
        return false;
    }
}

// Using KMP Algo
// Refer GFG Article for details
