/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/
import java.util.*;
public class Solution {
    public static void helper(List<Integer> res, TreeNode root){
        if(root==null) return;
        helper(res, root.left);
        res.add(root.data);
        helper(res, root.right);
    }
    public static List < Integer > getInOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> res=new ArrayList<Integer>();
        helper(res, root);
        return res;
    }
}