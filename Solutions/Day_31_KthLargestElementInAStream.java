import java.util.*;
public class Kthlargest {
    PriorityQueue<Integer> pq=new PriorityQueue();
    Kthlargest(int k, int[] arr) {
        // Write your code here.
        for(int i:arr)
            pq.add(i);
    }

    void add(int num) {
        // Write your code here.
        if(num<=pq.peek())
            return;
        pq.add(num);
        pq.remove();
    }

    int getKthLargest() {
        // Write your code here.
        return pq.peek();
    }
}
