import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
        if(head==null) return head;
        LinkedListNode<Integer> cur=head;
        // Inserting new node in between
        while(cur!=null){
            LinkedListNode<Integer> temp=cur.next;
            cur.next=new LinkedListNode(cur.data);
            cur.next.next=temp;
            cur=temp;
        }
        cur=head;
        // Setting random pointers
        while(cur!=null){
            if(cur.random!=null)
                cur.next.random=cur.random.next;
            cur=cur.next.next;
        }
        LinkedListNode<Integer> original=head, clone=head.next;
        LinkedListNode<Integer> temp=clone;
        // Separate both the nodes
        while(original!=null){
            original.next=original.next.next;
            clone.next=original.next;
            original=original.next;
            clone=clone.next;
        }
        return temp;
        
	}
}
