/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

import java.util.*;
public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
        List<Integer> res=new ArrayList();
        if(root==null) return res;
        Queue<BinaryTreeNode<Integer>> q=new LinkedList();
        q.offer(root);
        boolean invert=false;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList();
            for(int i=0;i<size;i++){
                BinaryTreeNode<Integer> curr=q.poll();
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
                if(invert)
                    list.add(0, curr.data);
                else
                    list.add(curr.data);
            }
            invert=!invert;
            for(int i:list)
                res.add(i);
        }
        return res;
	}
}
