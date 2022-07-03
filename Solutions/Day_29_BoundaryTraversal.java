/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

public class Solution {
    public static boolean isLeaf(TreeNode root){
        return (root.left==null)&&(root.right==null);
    }
    public static void addLeft(ArrayList<Integer> res, TreeNode root){
        root=root.left;
        while(root!=null){
            if(!isLeaf(root)) res.add(root.data);
            if(root.left!=null) root=root.left;
            else root=root.right;
        }
    }
    public static void addLeaf(ArrayList<Integer> res, TreeNode root){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left!=null) addLeaf(res, root.left);
        if(root.right!=null) addLeaf(res, root.right);
    }
    public static void addRight(ArrayList<Integer> res, TreeNode root){
        root=root.right;
        ArrayList<Integer> al=new ArrayList();
        while(root!=null){
            if(!isLeaf(root)) al.add(0, root.data);
            if(root.right!=null) root=root.right;
            else root=root.left;
        }
        for(int i:al)
            res.add(i);
    }
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList<Integer> res=new ArrayList();
        if(!isLeaf(root)) res.add(root.data);
        addLeft(res, root);
        addLeaf(res, root);
        addRight(res, root);
        return res;
	}
}