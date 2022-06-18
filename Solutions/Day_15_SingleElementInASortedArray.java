import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        //    Write your code here.
        int n=arr.size();
        if(n==1 || (!arr.get(0).equals(arr.get(1)))) return arr.get(0);
        if(!arr.get(n-1).equals(arr.get(n-2))) return arr.get(n-1);
        int low=0, high=n-1;
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(mid%2==0){
                if(!arr.get(mid).equals(arr.get(mid+1)))
                    high=mid-1;
                else low=mid+1;
            }else{
                if(arr.get(mid).equals(arr.get(mid+1)))
                    high=mid-1;
                else low=mid+1;
            }
        }
        return arr.get(low);
    }
}