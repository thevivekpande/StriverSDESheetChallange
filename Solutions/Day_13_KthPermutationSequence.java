import java.util.*;
public class Solution {
    public static String kthPermutation(int n, int k) {
        // Write your code here.
        int fact=1;
        List<Integer> arr=new ArrayList();
        for(int i=1;i<n;i++){
            fact*=i;
            arr.add(i);
        }
        arr.add(n);
        k--;
        String res="";
        while(true){
            res+=arr.get(k/fact);
            arr.remove(k/fact);
            if(arr.size()==0) break;
            k%=fact;
            fact/=arr.size();
        }
        return res;
    }
}