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

// #M2 Using KMP Algo
// Refer GFG Article for details

public class Solution {
    private static void fillLps(String str, int[] lps){
        int n=str.length(), len=0;
        lps[0]=0;
        int i=1;
        while(i<n){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len==0){
                    lps[i]=0;
                    i++;
                }else{
                    len=lps[len-1];
                }
            }
        }
    }
    public static boolean findPattern(String p, String s) {
        // Write your code here.
        int m=p.length(), n=s.length();
        int[] lps=new int[m];
        fillLps(p, lps);
        int i=0, j=0;
        while(i<n){
            if(p.charAt(j)==s.charAt(i)){
                i++;
                j++;
            }
            if(j==m) return true;
            else if(i<n && p.charAt(j)!=s.charAt(i)){
                if(j==0)
                    i++;
                else
                    j=lps[j-1];
            }
        }
        return false;
    }
}