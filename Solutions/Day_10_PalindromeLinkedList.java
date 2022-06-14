import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

    static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> pre=null;
    LinkedListNode<Integer> nex=null;
    while(head!=null) {
        nex = head.next;
        head.next = pre;
        pre=head;
        head=nex;
    }
    return pre;
}
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		// Write your code here!
        if(head==null || head.next==null) return true;
        LinkedListNode<Integer> slow=head;
        LinkedListNode<Integer> fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=reverse(slow.next);
        slow=slow.next;
        while(slow!=null && head!=null){
            if(!head.data.equals(slow.data)) return false;
            slow=slow.next;
            head=head.next;
        }
        return true;
	}
}