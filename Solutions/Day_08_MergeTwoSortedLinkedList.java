import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// Write your code here.
        LinkedListNode<Integer> temp=new LinkedListNode(0);
        LinkedListNode<Integer> res=temp;
        while(first!=null && second!=null){
            if(first.data<second.data){
                temp.next=first;
                temp=temp.next;
                first=first.next;
            }else{
                temp.next=second;
                second=second.next;
                temp=temp.next;
            }
        }
        
        if(first!=null) temp.next=first;
        if(second!=null) temp.next=second;
        
        return res.next;
	}
}