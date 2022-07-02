/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.*;
public class Solution {
  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
    //Your code goes here
      ArrayList<Integer> res=new ArrayList();
      if(root==null) return res;
      Queue<BinaryTreeNode> q=new LinkedList();
      q.offer(root);
      while(!q.isEmpty()){
          int size=q.size();
          for(int i=0;i<size;i++){
              if(q.peek().left!=null)
                  q.offer(q.peek().left);
              if(q.peek().right!=null)
                  q.offer(q.peek().right);
              res.add(q.poll().val);
          }
      }
      return res;
  }

}