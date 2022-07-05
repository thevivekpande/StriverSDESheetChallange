/*************************************************************************

    Following is the class structure of the Node class:

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************************/
class NodeInfo{
    int maxi;
    int mini;
    boolean isBst;
    int size;
    NodeInfo(){}
    NodeInfo(int _maxi, int _mini, boolean _isBst, int _size){
        maxi=_maxi;
        mini=_mini;
        isBst=_isBst;
        size=_size;
    }
}
public class Solution {
    public static NodeInfo helper(TreeNode<Integer> root){
        if(root==null)
            return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        
        NodeInfo left=helper(root.left);
        NodeInfo right=helper(root.right);
        
        NodeInfo returnInfo=new NodeInfo();
        
        returnInfo.mini=Math.min(root.data, Math.min(left.mini, right.mini));
        returnInfo.maxi=Math.max(root.data, Math.max(left.maxi, right.maxi));
        returnInfo.isBst=left.isBst && right.isBst && (left.maxi<root.data && right.mini>root.data);
        
        if(returnInfo.isBst)
            returnInfo.size=left.size+right.size+1;
        else
            returnInfo.size=Math.max(right.size, left.size);
        
        return returnInfo;
        
    }
	public static int largestBST(TreeNode<Integer> root) {
		// Write your code here.
        return helper(root).size;
	}
}
