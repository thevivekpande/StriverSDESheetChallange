/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
import java.util.*;
class Pair{
    BinaryTreeNode<Integer> node;
    int num;
    Pair(BinaryTreeNode<Integer> _node, int _num){
        node=_node;
        num=_num;
    }
}

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        
        List<Integer> in=new ArrayList<>();
        List<Integer> pre=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(root, 1));
        
        while(!stack.isEmpty()){
            Pair curr=stack.pop();
            // PreOrder Traversal
            if(curr.num==1){
                pre.add(curr.node.data);
                curr.num++;
                stack.push(curr);
                if(curr.node.left!=null){
                    stack.push(new Pair(curr.node.left, 1));
                }
            }
            // Inorder Traversal
            else if(curr.num==2){
                in.add(curr.node.data);
                curr.num++;
                stack.push(curr);
                if(curr.node.right!=null){
                    stack.push(new Pair(curr.node.right, 1));
                }
            }
            // PostOrder Traversal
            else{
                post.add(curr.node.data);
            }
        }
        
        res.add(in);
        res.add(pre);
        res.add(post);
        
        return res;
    }
}
