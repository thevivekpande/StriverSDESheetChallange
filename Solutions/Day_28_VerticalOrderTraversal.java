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
class Pair{
    TreeNode<Integer> node;
    int hd;
    Pair(TreeNode<Integer> _node, int _hd){
        node=_node;
        hd=_hd;
    }
}
public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> res=new ArrayList();
        TreeMap<Integer, ArrayList<Integer>> map=new TreeMap();
        Queue<Pair> q=new LinkedList();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
            Pair cur=q.poll();
            if(map.get(cur.hd)==null)
                map.put(cur.hd, new ArrayList());
            map.get(cur.hd).add(cur.node.data);
            if(cur.node.left!=null)
                q.offer(new Pair(cur.node.left, cur.hd-1));
            if(cur.node.right!=null)
                q.offer(new Pair(cur.node.right, cur.hd+1));
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> al=entry.getValue();
            for(int i: al)
                res.add(i);
        }
        return res;
    }
}
