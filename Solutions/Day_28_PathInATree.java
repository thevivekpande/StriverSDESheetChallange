/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/
import java.util.*;
public class Solution {
    public static boolean helper(ArrayList<Integer> res, int x, TreeNode root){
        if(root==null) return false;
        res.add(root.data);
        if(root.data==x)
            return true;
        if(helper(res, x, root.left)) return true;
        if(helper(res, x, root.right)) return true;
        res.remove(res.size()-1);
        return false;
    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> res=new ArrayList();
        helper(res, x, root);
        return res;
    }
}