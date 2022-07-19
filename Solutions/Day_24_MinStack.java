import java.util.*;
class Pair{
    int num;
    int min;
    Pair(int x, int y){
        num=x;
        min=y;
    }
} 

class MinStack {
    Stack<Pair> minStack;
    // Constructor
    MinStack() {
        // Write your code here.
        minStack=new Stack<>();
    }

    // Function to add another element equal to num at the top of stack.
    void push(int num) {
        // Write your code here.
        int min=Integer.MAX_VALUE;
        if(minStack.isEmpty())
            min=num;
        else 
            min=Math.min(min, minStack.peek().min);
        minStack.push(new Pair(num, min));
    }

    // Function to remove the top element of the stack.
    int pop() {
        // Write your code here.
        return minStack.isEmpty()?-1:minStack.pop().num;
    }

    // Function to return the top element of stack if it is present. Otherwise
    // return -1.
    int top() {
        // Write your code here.
        return minStack.isEmpty()?-1:minStack.peek().num;
    }

    // Function to return minimum element of stack if it is present. Otherwise
    // return -1.
    int getMin() {
        // Write your code here.
        return minStack.isEmpty()?-1:minStack.peek().min;
    }
};
