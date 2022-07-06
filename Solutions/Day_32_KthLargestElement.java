import java.util.*;
public class Solution {
	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		// Write your code here.
        int res=-1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<K;i++)
            pq.add(arr.get(i));
        for(int i=K;i<size;i++){
            if(arr.get(i)>pq.peek()){
                pq.offer(arr.get(i));
                pq.remove();
            }
        }
        return pq.peek();
	}
}
