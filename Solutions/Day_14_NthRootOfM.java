public class Solution {
    public static double mul(double num, int n){
        double res=1.0;
        for(int i=0;i<n;i++)
            res*=num;
        return res;
    }
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        double low=1, high=m;
        double e=1e-7;
        while((high-low)>e){
            double mid=low+((high-low)/2.0);
            if(mul(mid, n)<m){
                low=mid;
            }else{
                high=mid;
            }
        }
        return low;
    }
}


#M2
public class Solution {
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        return Math.pow(m,1.000000/n);
    }
}