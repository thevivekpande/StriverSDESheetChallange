public class Solution 
{
	public static String reverseString(String str) 
	{
        StringBuilder res = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == ' ')
                continue;
            int j=i;
            while((j>=0) && (str.charAt(j)!=' '))
                j--;
            res.append(str.substring(j+1, i+1));
            res.append(" ");
            i=j;
        }
        return res.toString();
	}
}
