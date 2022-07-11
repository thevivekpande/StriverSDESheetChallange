import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        // Write your code here.
        ArrayList<Integer> temp=new ArrayList();
        for(int i:rack) temp.add(i);
        int res=rack.get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(rack.get(j)<rack.get(i)){
                    temp.set(i, Math.max(temp.get(i), temp.get(j)+rack.get(i)));
                    res=Math.max(res, temp.get(i));
                }
            }
        }
        return res;
    }
}