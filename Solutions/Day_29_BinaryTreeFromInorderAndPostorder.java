/************************************************************
  
   Following is the TreeNode class structure
   
   class TreeNode<T> { 
        T data; 
        TreeNode<T> left;
        TreeNode<T> right;
  
        TreeNode(T data) { 
            this.data = data; 
            left = null; 
            right = null; 
        }
   }
    
 ************************************************************/
import java.util.*;
public class Solution {
    public static TreeNode<Integer> buildTree(int[] postOrder, int postStart, int postLast, int[] inOrder, int inStart, int inLast, Map<Integer, Integer> inMap){
        
        if(inStart>inLast || postStart>postLast)
            return null;
        
        TreeNode<Integer> root=new TreeNode(postOrder[postLast]);
        int inRoot=inMap.get(root.data);
        int numLeft=inRoot-inStart;
        
        root.left=buildTree(postOrder, postStart, postStart+numLeft-1, inOrder, inStart, inRoot-1, inMap);
        root.right=buildTree(postOrder, postStart+numLeft, postLast-1, inOrder, inRoot+1, inLast, inMap);
        
        return root;
    }

	public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
		// Write your code here.
        if(inOrder==null || postOrder==null || inOrder.length!=postOrder.length)
            return null;
        Map<Integer, Integer> inMap = new HashMap();
        for(int i=0;i<inOrder.length;i++)
            inMap.put(inOrder[i], i);
        TreeNode<Integer> root= buildTree(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1, inMap);
        return root;
	}
}
