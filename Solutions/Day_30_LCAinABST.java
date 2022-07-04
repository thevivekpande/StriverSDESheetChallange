/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class Solution 
{

	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
    {		
        // Write your code here
        if(root==null) return null;
        if(root==p || root==q) return root;
        TreeNode<Integer> left=LCAinaBST(root.left, p, q);
        TreeNode<Integer> right=LCAinaBST(root.right, p, q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
	}
}