/************************************************************

    Following is the TreeNode class structure.

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/

public class Solution 
{
    static TreeNode<Integer> prev;
    public static void helper(TreeNode<Integer> root){
        if(root==null) return;
        helper(root.right);
        helper(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
        // Write your code here.
        helper(root);
        prev=null;
        return root;
    }
}