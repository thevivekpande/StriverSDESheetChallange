import java.util.* ;
import java.io.*; 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

*****************************************************************/
public class Solution {
    public static Node merge(Node left, Node right){
        Node dummy=new Node(0);
        Node res=dummy;
        while(left!=null && right!=null){
            if(left.data<right.data){
                dummy.child=left;
                left=left.child;
                dummy=dummy.child;
            }else{
                dummy.child=right;
                right=right.child;
                dummy=dummy.child;
            }
        }
        if(left!=null) dummy.child=left;
        if(right!=null) dummy.child=right;
        return res.child;
    }
	public static Node flattenLinkedList(Node start) {
		 //Write your code here'
        if(start==null || start.next==null) return start;
        Node left=start;
        Node right=flattenLinkedList(start.next);
        return merge(left, right); 
	}
}

