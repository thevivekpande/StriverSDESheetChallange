import java.util.* ;
import java.io.*; 
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {

	public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		HashSet<LinkedListNode<Integer>> hash=new HashSet();
        while(firstHead!=null){
            hash.add(firstHead);
            firstHead=firstHead.next;
        }
        while(secondHead!=null){
            if(hash.contains(secondHead)) return secondHead.data;
            secondHead=secondHead.next;
        }
        return -1;
	}
}