import java.util.* ;
import java.io.*; 
public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here.  
        long res=1, xx=x;
        while(n>0){
            if(n%2==0){
                xx=(xx%m * xx%m)%m;
                n>>=1;
            }else{
                res=(res*xx%m)%m;
                n--;
            }
        }
        return (int)(res%m);
    }
}