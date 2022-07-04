/************************************************************

    Following is the TreeNode class structure

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
    public static int helper(TreeNode<Integer> root, int[] i){
        if(root==null) return -1;
        int left=helper(root.left, i);
        if(left!=-1)
            return left;
        i[0]--;
        if(i[0]==0)
            return root.data;
        return helper(root.right, i);
    }
	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{
		//  Write your code here.
        int[] i=new int[1];
        i[0]=k;
        return helper(root, i);
	}

}
