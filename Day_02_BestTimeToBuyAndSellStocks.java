import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
		int min=prices.get(0), res=0;
		for(int i=1;i<prices.size();i++){
			res=Math.max(res, prices.get(i)-min);
			min=Math.min(min, prices.get(i));
		}
		return res;
    }
}