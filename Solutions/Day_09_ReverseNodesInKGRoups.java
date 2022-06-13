import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// Write your code here.
        if(head==null) return head;
        
        Node dummy = new Node(0);
        dummy.next = head;
        
        Node curr=dummy, nex=dummy, pre=dummy;
        int count=0;
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
        int ind=0;
        while(count>0 && ind<n){
            curr=pre.next;
            nex=curr.next;
            int k=Math.min(b[ind++], count);
            
            if(k==0)  
                continue;
            
            for(int i=1;i<k;i++){
                curr.next=nex.next;
                nex.next=pre.next;
                pre.next=nex;
                nex=curr.next;
            }
            pre=curr;
            count-=k;
        }
        return dummy.next;    
	}
}