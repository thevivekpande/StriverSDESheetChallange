/*
    Definition of Node class for reference

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

*/
import java.util.*;
public class Solution {

    static class BSTIterator{
        Stack<TreeNode<Integer>> stack=new Stack();
        BSTIterator(TreeNode<Integer> root){
            // Write your code here
            pushAll(root);
        }
        
        void pushAll(TreeNode<Integer> root){
            for(;root!=null;stack.push(root), root=root.left);
        }

        int next(){
            // Write your code here
            TreeNode<Integer> node=stack.pop();
            pushAll(node.right);
            return node.data;
        }

        boolean hasNext(){
            // Write your code here
            return !stack.isEmpty();
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
