/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
import java.util.*;
class Pair{
    BinaryTreeNode node;
    int hd;
    Pair(BinaryTreeNode _node, int _hd){
        node=_node;
        hd=_hd;
    }
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        ArrayList<Integer> res=new ArrayList();
        if(root==null)
            return res;
        Map<Integer, Integer> map=new TreeMap();
        Queue<Pair> q=new LinkedList();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair temp=q.poll();
            if(map.get(temp.hd)==null) map.put(temp.hd, temp.node.val);
            if(temp.node.left!=null)
                q.offer(new Pair(temp.node.left, temp.hd-1));
            if(temp.node.right!=null)
                q.offer(new Pair(temp.node.right, temp.hd+1));
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet())
            res.add(entry.getValue());
        return res;
	}
}