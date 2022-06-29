public class Solution {	
    public static int expandFromMid(String str, int i, int j){
        if(str==null || i>j) return 0;
        while(i>=0 && j<str.length() &&( str.charAt(i)==str.charAt(j))){
            i--;
            j++;
        }
        return j-i-1;
    }
	public static String longestPalinSubstring(String str) {
		// Write your code here.
        int start=0,last=0,currlen=0;
        for(int i=0;i<str.length();i++){
            int len1=expandFromMid(str, i, i);
            int len2=expandFromMid(str, i, i+1);
            int len=Math.max(len1, len2);
            if(len>currlen){
                start=i-((len-1)/2);
                last=i+((len)/2);
                currlen=len;
            }
        }
        return str.substring(start,last+1);
	}
}
