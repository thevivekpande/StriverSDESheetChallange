/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/
import java.util.*;
public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	// Write your code here.
        Queue<BinaryTreeNode<Integer>> q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                BinaryTreeNode<Integer> cur=q.poll();
                cur.next=i==size-1?null:q.peek();
                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)
                    q.offer(cur.right);
            }
        }
	}
}