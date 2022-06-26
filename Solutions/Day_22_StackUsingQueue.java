import java.util.*;
public class Stack {

    // Define the data members.
    Queue<Integer> queue;

    public Stack() {
        // Implement the Constructor.
        queue=new LinkedList<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        // Implement the getSize() function.
        return queue.size();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
        return queue.isEmpty();
    }

    public void push(int element) {
        // Implement the push(element) function.
        queue.offer(element);
        for(int i=0;i<queue.size()-1;i++)
            queue.offer(queue.poll());
    }

    public int pop() {
        // Implement the pop() function.
        return queue.isEmpty()?-1:queue.poll();
    }

    public int top() {
        // Implement the top() function.
        return queue.isEmpty()?-1:queue.peek();
    }
}