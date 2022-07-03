/************************************************************

    Following is the Tree node structure
	
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

public class Solution {
    static int leaves;
    public static long helper(TreeNode root, long[] res){
        if(root==null) return 0;
        if(root.left==null && root.right==null) leaves++;
        long left=helper(root.left, res);
        long right=helper(root.right, res);
        long temp=Math.max(left, right)+root.data;
        long maxSum=Math.max(temp, left+right+root.data);
        res[0]=Math.max(res[0], maxSum);
        return temp;
    }
	public static long findMaxSumPath(TreeNode root) {
		// Write your code here.
        if(root==null || (root.left==null && root.right==null))
            return -1;
        long[] res=new long[1];
        leaves=0;
        helper(root,res);
        return leaves==1?-1:res[0];
	}
}