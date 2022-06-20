import java.util.*;
public class Solution{
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
		// Write your code here.
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> res=new ArrayList();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.add(a.get(i)+b.get(j));
            }
        }
        for(int i=0;i<k;i++)
            res.add(pq.poll());
        return res;
	}
}