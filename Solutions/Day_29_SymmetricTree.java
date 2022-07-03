/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution {
    public static boolean helper(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right){
        if(left==null || right==null) return left==right;
        return (left.data.equals(right.data))&&(helper(left.left, right.right))&&(helper(left.right, right.left));
    }
    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        // Write your code here.
        return root==null || helper(root.left, root.right);
    }
}