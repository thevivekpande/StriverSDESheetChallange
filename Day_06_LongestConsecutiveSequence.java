import java.util.* ;
import java.io.*; 
public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
        HashSet<Integer> set=new HashSet();
        for(int a : arr)
            set.add(a);
        int res=0;
        for(int a :arr){
            if(!set.contains(a-1)){
                int temp=a;
                int curr=1;
                while(set.contains(temp+1)){
                    temp++;
                    curr++;
                }
                res=Math.max(res, curr);
            }
        }
        
        return res;
    }
}