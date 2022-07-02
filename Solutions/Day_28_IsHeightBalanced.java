/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
public class Solution {
    public static int height(BinaryTreeNode<Integer> root){
        if(root==null) return 0;
        int lh=1+height(root.left);
        int rh=1+height(root.right);
        return Math.max(rh,lh);
    }
	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		// Write your code here.
        if(root==null) return true;
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(lh-rh)>=2 || !isBalancedBT(root.left) || !isBalancedBT(root.right)) return false;
        return true;
	}
}
