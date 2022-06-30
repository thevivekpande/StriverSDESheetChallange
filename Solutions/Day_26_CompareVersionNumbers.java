import java.math.BigInteger;
public class Solution 
{
    public static int compareVersions(String a, String b) 
    {
        // Write your code here
        String[] s1=a.split("\\.");
        String[] s2=b.split("\\.");
        int maxLen=Math.max(s1.length, s2.length);
        for(int i=0;i<maxLen;i++){
            BigInteger v1=i<s1.length?new BigInteger(s1[i]):BigInteger.ZERO;
            BigInteger v2=i<s2.length?new BigInteger(s2[i]):BigInteger.ZERO;
            if(v1.compareTo(v2)==1) return 1;
            if(v1.compareTo(v2)==-1) return -1;
        }
        return 0;
    }
}