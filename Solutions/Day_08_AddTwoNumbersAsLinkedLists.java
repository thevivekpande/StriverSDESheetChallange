import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode temp=new LinkedListNode(0);
        LinkedListNode res=temp;
        int carry=0;
        while(head1!=null || head2!=null){
            int sum=carry;
            sum+=head1!=null?head1.data:0;
            sum+=head2!=null?head2.data:0;
            temp.next=new LinkedListNode(sum%10);
            temp=temp.next;
            head1=head1!=null?head1.next:head1;
            head2=head2!=null?head2.next:head2;
            carry=sum/10;
        }
        if(carry!=0) temp.next=new LinkedListNode(carry);
        return res.next;
    }
}