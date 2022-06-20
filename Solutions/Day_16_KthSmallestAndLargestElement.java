import java.util.*;
public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		//Write your code here
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        ArrayList<Integer> res=new ArrayList();
        for(int i:arr)
            pq.add(i);
        int first=0, second=0;
        for(int i=0;i<n;i++){
            int temp=pq.poll();
            if(i==k-1) 
                first=temp;
            if(i==n-k)
                second=temp;
        }
        res.add(first);
        res.add(second);
        return res;
	}
}
