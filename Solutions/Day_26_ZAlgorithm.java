// #M1 Using Rabin Karp Algo
public class Solution {
	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
        int pat=0, tex=0;
        int res=0;
        for(int i=0;i<m;i++){
            pat+=(int)p.charAt(i);
            tex+=(int)s.charAt(i);
        }
        for(int i=0;i<=n-m;i++){
            if(pat==tex && p.equals(s.substring(i, i+m)))
                res++;
            if(i<n-m){
                tex+=(int)s.charAt(i+m);
                tex-=(int)s.charAt(i);
            }
        }
        return res;
	}

}


// #M2 Using Z Algorithm
// Follow this link for better understanding : https://personal.utdallas.edu/~besp/demo/John2010/z-algorithm.htm
// Also Check GFG Article for details

public class Solution {
    private static void getZArr(String str, int[] Z, int n){
        int L=0, R=0;
        for(int i=0;i<n;i++){
            if(i>R){
                L=R=i;
                while(R<n && str.charAt(R-L)==str.charAt(R))
                    R++;
                Z[i]=R-L;
                R--;
            }else{
                int k=i-L;
                if(Z[k]<R-i+1)
                    Z[i]=Z[k];
                else{
                    L=i;
                    while(R<n && str.charAt(R-L)==str.charAt(R))
                        R++;
                    Z[i]=R-L;
                    R--;
                }
            }
        }
    }
	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
        String concat=p+"$"+s;
        int l=n+m+1;
        int[] Z=new int[l];
        
        //Construct Z Array
        getZArr(concat, Z, l);
        int res=0;
        
        for(int i=0;i<l;i++){
            if(Z[i]==m)
                res++;
        }
        return res;
	}

}