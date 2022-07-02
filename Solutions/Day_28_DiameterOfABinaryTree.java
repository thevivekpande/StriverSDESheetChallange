/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

public class Solution {
    public static int helper(TreeNode<Integer> root, int[] res){
        if(root==null) return 0;
        int leftHeight=helper(root.left, res);
        int rightHeight=helper(root.right, res);
        res[0]=Math.max(res[0], leftHeight + rightHeight);
        return 1+Math.max(leftHeight, rightHeight);
    }
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		// Write your code here.
        int[] res=new int[1];
        helper(root, res);
        return res[0];
	}
}