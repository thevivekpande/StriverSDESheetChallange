
import java.util.*;
public class Solution {
	public static void findMedian(int arr[])  {
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        if(arr.length==0) return;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        // maxHeap - maintaining left side, always return max of left side.
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        // minHeap - maintaining right side, always return min of right side.
        int median=arr[0];
        System.out.print(median+" ");
        maxHeap.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            int num=arr[i];
            if(maxHeap.size()>minHeap.size()){
                // Left part is greater
                if(median>num){
                    // num lesser than median should always go on left side
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                }else{
                    minHeap.add(num);
                }
                median=(minHeap.peek()+maxHeap.peek())/2;
            }else if(maxHeap.size()==minHeap.size()){
                // both part is equals
                if(num<median){
                    // num lesser than median should always go on left side
                    maxHeap.add(num);
                    median=maxHeap.peek();
                }else{
                    // num greater than median should always go on right side
                    minHeap.add(num);
                    median=minHeap.peek();
                }
            }else{
                // right part is greater
                if(num>median){
                    // num greater than median should always go on right side
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }else{
                    maxHeap.add(num);
                }
                median=(maxHeap.peek()+minHeap.peek())/2;
            }
            System.out.print(median+" ");
        }
     }
}