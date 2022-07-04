/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;
public class Solution {
    public static int helper(TreeNode<Integer> root, int[] i){
        if(root==null) return -1;
        int right=helper(root.right, i);
        if(right!=-1)
            return right;
        i[0]--;
        if(i[0]==0)
            return root.data;
        return helper(root.left, i);
    }
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		// Write your code here.
        int[] i=new int[1];
        i[0]=k;
        return helper(root, i);
	}
}