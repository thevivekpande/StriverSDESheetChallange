/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/
import java.util.*;
public class Solution {
    static HashSet<Integer> set=new HashSet<>();
    public static boolean pairSum(BinaryTreeNode root, int k){
        if(root==null) return false;
        if(set.contains(k - root.data)) return true;
        set.add(root.data);
        return pairSum(root.left, k) || pairSum(root.right, k);
    }
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		// Write your code here.
        boolean res=pairSum(root, k);
        set.clear();
        return res;
	}
}

