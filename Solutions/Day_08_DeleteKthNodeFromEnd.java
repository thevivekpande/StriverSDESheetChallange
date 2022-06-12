import java.util.* ;
import java.io.*; 
/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
		// Write your code here.
        if(K==0) return head;
        LinkedListNode<Integer> res=new LinkedListNode(0);
        res.next=head;
        LinkedListNode<Integer> fast=res;
        LinkedListNode<Integer> slow=res;
        for(int i=0;i<K;i++)
            fast=fast.next;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return res.next;
	}
}
