import java.util.*;
public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        int[] res=new int[n];
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        // maxHeap - maintaining left side, always return max of left side.
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        // minHeap - maintaining right side, always return min of right side.
        int median=arr[0];
        res[0]=median;
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
            res[i]=median;
        }
        return res;
    }
}
