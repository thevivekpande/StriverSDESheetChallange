/*************************************************************
    Following is the Binary Tree node structure

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
    private static int pre;
    private static int succ;
    public static void helper(BinaryTreeNode<Integer> root, int key){
        if(root==null) return;
        helper(root.left, key);
        if(root.data<key){
            pre=Math.max(pre,root.data);
        }
        if(root.data>key){
            succ=Math.min(succ,root.data);
        }
        helper(root.right, key);
    }
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
        ArrayList<Integer> res=new ArrayList();
        pre=Integer.MIN_VALUE;
        succ=Integer.MAX_VALUE;
        helper(root, key);
        res.add(pre==Integer.MIN_VALUE?-1:pre);
        res.add(succ==Integer.MAX_VALUE?-1:succ);
        return res;
	}
}