import java.util.*;
public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> in;
    Stack<Integer> out;

    Queue() {
        // Initialize your data structure here.
        in=new Stack<Integer>();
        out=new Stack<Integer>();
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        while(!in.isEmpty()){
            out.push(in.pop());
        }
        
        in.push(val);
        
        while(!out.isEmpty()){
            in.push(out.pop());
        }
    }

    int deQueue() {
        // Implement the dequeue() function
        return in.isEmpty()?-1:in.pop();
    }

    int peek() {
        // Implement the peek() function here.
        return in.isEmpty()?-1:in.peek();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        return in.isEmpty();
    }
}