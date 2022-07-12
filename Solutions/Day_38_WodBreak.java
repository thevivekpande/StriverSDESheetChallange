import java.util.*;
public class Solution {
    public static Boolean wordBreak(String[] arr, int n, String target) { 
        int i,j,k;
        TreeSet<String> map = new TreeSet<String>(); 
        for(String str:arr)
            map.add(str);
    
        int len = target.length();

        ArrayList<Boolean> dp = new ArrayList<Boolean>(len + 1);
        for(i=0;i<len;i++)
            dp.add(i,false);
            
        dp.add(0,true);
    
        for(i = 1; i <= len; i++) {
            for(j = 0; j <len; j++) {
                if(dp.get(j) && map.contains(target.substring(j, i))){
                    dp.add(i,true);
                    break;
                }
            }
        }
        return dp.get(len);
    }
}