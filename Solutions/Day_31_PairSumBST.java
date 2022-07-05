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
// #M1 Using HashSet
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

// #M2 Using Binary Search
public class Solution {
    public static boolean binarySearch(BinaryTreeNode root, BinaryTreeNode cur, int k){
        while(root!=null){
            if(root.data==k && root!=cur) return true;
            else if(root.data>k) root=root.left;
            else root=root.right;
        }
        return false;
    }
    public static boolean dfs(BinaryTreeNode root, BinaryTreeNode cur, int k){
        if(cur==null) return false;
        return (binarySearch(root, cur, k-cur.data) || dfs(root, cur.left, k) || dfs(root, cur.right, k));
    }
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		// Write your code here.
        if(root==null) return false;
        return dfs(root, root, k);
	}
}
