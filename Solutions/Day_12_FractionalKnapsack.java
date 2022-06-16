/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/
import java.util.*;

public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
        Arrays.sort(items, (a,b)->Double.compare(((double)b.value/(double)b.weight),((double)a.value/(double)a.weight)));
        double res=0.0;
        int i=0;
        while(w>0 && i<n){
            if(items[i].weight<=w){
                w-=items[i].weight;
                res+=items[i].value;
            }else{
                res+=items[i].value*((double)w/(double)(items[i].weight));
                break;
            }
            i++;
        }
        return res;
    }
}
