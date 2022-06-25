
public class Stack {
    int size;
    int[] arr;
    int top;
    
    Stack(int size){
        top=-1;
        this.size=size;
        arr=new int[size];
    }
    void push(int num) {
        // Write your code here.
        if(top<size-1)        
            arr[++top]=num;
    }
    int pop() {
        // Write your code here.
        if(top!=-1)
            return arr[top--];
        else
            return -1;
    }
    int top() {
        // Write your code here.
        if(top!=-1 && top<size)
            return arr[top];
        else
            return -1;
    }
    int isEmpty() {
        // Write your code here.
        return top==-1?1:0;
    }
    int isFull() {
        // Write your code here.
        return top>=size?1:0;
    }
}
