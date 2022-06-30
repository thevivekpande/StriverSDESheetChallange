public class Solution 
{
    public static String writeAsYouSpeak(int n) 
    {
        // Write your code here.
        if(n==1) return "1";
        StringBuilder res=new StringBuilder();
        // X is here for handling edges cases s.charAt(i+1) at line 11
        // and will not be used in our res.
        String s=writeAsYouSpeak(n-1)+"X";
        for(int i=0, c=1;i<s.length()-1;i++,c++){
            if(s.charAt(i+1)!=s.charAt(i)){
                res.append(c).append(s.charAt(i));
                c=0;
            }
        }
        return res.toString();
    }
}