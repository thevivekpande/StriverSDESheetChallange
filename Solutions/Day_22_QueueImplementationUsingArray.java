import java.util.*;
public class Queue {
    int front;
    int rear;
    ArrayList<Integer> arr;
    Queue() {
        // Implement the Constructor
        arr=new ArrayList();
        front=0;
        rear=0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return front<=rear;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        arr.add(data);
        front++;
    }

    int dequeue() {
        // Implement the dequeue() function
        return front>rear?arr.get(rear++):-1;
    }

    int front() {
        // Implement the front() function
        return front>rear?arr.get(rear):-1;
    }

}
