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
    public static String serializeTree(TreeNode<Integer> root)
    {
        //    Write your code here for serialization of the tree.
        if(root==null) return "#";
        StringBuilder res=new StringBuilder();
        Queue<TreeNode<Integer>> q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode<Integer> cur=q.poll();
            if(cur==null){
                res.append("# ");
                continue;
            }
            res.append(cur.data+" ");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return res.toString();
    }
    
    public static TreeNode<Integer> deserializeTree(String str)
    {
        //    Write your code here for deserialization of the tree.
        if(str=="#") return null;
        String[] input=str.split(" ");
        Queue<TreeNode<Integer>> q=new LinkedList();
        TreeNode<Integer> root=new TreeNode(Integer.parseInt(input[0]));
        q.offer(root);
        for(int i=1;i<input.length;i++){
            TreeNode<Integer> cur=q.poll();
            if(!input[i].equals("#")){
                TreeNode<Integer> left=new TreeNode(Integer.parseInt(input[i]));
                cur.left=left;
                q.offer(left);
            }
            if(!input[++i].equals("#")){
                TreeNode<Integer> right=new TreeNode(Integer.parseInt(input[i]));
                cur.right=right;
                q.offer(right);
            }
        }
        return root;
    }
}
