
/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution {
	static BinaryTreeNode<Integer> head, prev;
    private static void helper(BinaryTreeNode<Integer> root){
        if(root==null) return ;
        helper(root.left);
        if(prev==null){
            head=root;
        }else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        helper(root.right);
    }
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		// Write your code here
        head=null;
        prev=null;
        helper(root);
        return head;
	}
}
