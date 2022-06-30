public class Solution {
    public static int atoi(String str) {
        // Write your code here.
        if(str.length()==0) return 0;
        int i=0, sign=1, n=str.length();
        if(str.charAt(i)=='+' || str.charAt(i)=='-') sign=str.charAt(i++)=='+'?1:-1;
        long res=0;
        while(i<n){
            if(Character.isDigit(str.charAt(i)))
                res=res*10+(str.charAt(i)-'0');
            i++;
        }
        return (int)(sign*res);
    }
}
