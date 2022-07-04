 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
// #M1 Using Sorted Array to BST Approach

import java.util.*;
public class Solution {
    public static TreeNode<Integer> helper(int[] preOrder, int start, int last){
        if(start>last) return null;
        int mid=start+((last-start)>>1);
        TreeNode<Integer> root=new TreeNode(preOrder[mid]);
        root.left=helper(preOrder, start, mid-1);
        root.right=helper(preOrder, mid+1, last);
        return root;
    }
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		// Write your code here
        Arrays.sort(preOrder);
        return helper(preOrder, 0, preOrder.length-1);
	}

}

// #M2 Optimal

public class Solution {
    static int i;
    public static TreeNode<Integer> helper(int[] preOrder, int max){
        if(i==preOrder.length || preOrder[i]>max)
            return null;
        TreeNode<Integer> root=new TreeNode(preOrder[i]);
        i++;
        root.left=helper(preOrder, root.data);
        root.right=helper(preOrder, max);
        return root;
    }
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		// Write your code her
        i=0;
        return helper(preOrder,  Integer.MAX_VALUE);
	}

}
