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

// Recursive Code
/*
    1->2->3->4->N
    
    Assuming that recursive call has already reversed the rest of the node and we have to reverse only initial node.
    1->(2<-3<-4<-newHead)
    head -> 1
    head.next->2
    head.next.next=head => 2->1
    head.next=null => 2->1->N
    Final => N<-1<-2<-3<-4<-newHead
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
