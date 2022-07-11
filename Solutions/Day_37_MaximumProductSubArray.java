import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
        int res=Integer.MIN_VALUE, maxProduct=1, minProduct=1;
        int product=1;
        for(int i : arr){
            if(i<0){
                int temp=minProduct;
                minProduct=maxProduct;
                maxProduct=temp;
            }
            minProduct=Math.min(i, minProduct*i);
            maxProduct=Math.max(i, maxProduct*i);
            res=Math.max(res, maxProduct);
        }
        return res;
	}
}