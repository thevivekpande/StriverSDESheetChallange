import java.util.ArrayList;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
        int r=matrix.size(), c=matrix.get(0).size();
        int low=matrix.get(0).get(0);
        int high=matrix.get(0).get(0);
        for(int i=0;i<r;i++){
            low=Math.min(low, matrix.get(i).get(0));
            high=Math.max(high, matrix.get(i).get(c-1));
        }
        while(low<=high){
            int mid=low+((high-low)>>1);
            int count=0;
            for(int i=0;i<r;i++)
                count+=numLessAndEquals(matrix, i, c, mid);
            if(count<=(r*c)/2)
                low=mid+1;
            else high=mid-1;
        }
        return low;
	}
    public static int numLessAndEquals(ArrayList<ArrayList<Integer>> matrix, int ind, int col, int mid){
        int low=0, high=col-1;
        while(low<=high){
            int md=low+((high-low)>>1);
            if(matrix.get(ind).get(md)<=mid) low=md+1;
            else high=md-1;
        }
        return low;
    }
}