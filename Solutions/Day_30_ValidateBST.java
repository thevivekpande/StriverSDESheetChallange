/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root==null) return true;
        if(root.left!=null && root.left.data>root.data)
            return false;
        if(root.right!=null && root.right.data<root.data)
            return false;
        return validateBST(root.left)&&validateBST(root.right);
    }
}
