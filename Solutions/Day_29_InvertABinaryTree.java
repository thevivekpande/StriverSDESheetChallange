/************************************************************

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

************************************************************/
import java.util.*;
public class Solution 
{
    public static Stack<TreeNode<Integer>> stack;
    public static boolean helper(TreeNode<Integer> root, TreeNode<Integer> leaf){
        stack.push(root);
        if(root.left==null && root.right==null){
            if(root.data.equals(leaf.data))
                return true;
            else{
                stack.pop();
                return false;
            }
        }
        if(root.left!=null)
            if(helper(root.left, leaf))
                return true;
        
        if(root.right!=null)
            if(helper(root.right, leaf))
                return true;
        
        stack.pop();
        return false;
        
    }
    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        // Write your code here.
        if(root==null) return null;
         stack=new Stack();
        boolean f=helper(root, leaf);
        TreeNode<Integer> new_root=stack.pop();
        TreeNode<Integer> parent=new_root;
        while(!stack.isEmpty()){
            TreeNode<Integer> cur=stack.pop();
            if(cur.left==parent){
                cur.left=null;
                parent.left=cur;
            }else{
                cur.right=cur.left;
                cur.left=null;
                parent.left=cur;
            }
            parent=cur;
        }
        return new_root;
    }
}
