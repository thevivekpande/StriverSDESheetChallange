import java.util.* ;
import java.io.*; 
/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
        LinkedListNode<Integer> curr=head;
        LinkedListNode<Integer> temp=null;
        LinkedListNode<Integer> prev=null;
        
        while(curr!=null){
            temp=prev;
            prev=curr;
            curr=curr.next;
            prev.next=temp;
        }
         
        return prev;
    }
}