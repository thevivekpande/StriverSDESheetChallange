import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        int c=1;
        Node temp=head;
        Node temp1=null;
        while(temp.next!=null){
            temp=temp.next;    
            c++;
        }
        temp.next=head;
        k%=c;
        k=c-k;
        while(k-- > 0) temp=temp.next;
        head=temp.next;
        temp.next=null;
        return head;
    }
}