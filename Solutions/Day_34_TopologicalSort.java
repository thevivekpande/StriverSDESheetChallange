import java.util.*;
public class Solution 
{
    public static void dfs(int node, Stack<Integer> stack, HashMap<Integer, ArrayList<Integer>> adj, boolean[] isVis){
        isVis[node]=true;
        for(int it:adj.get(node))
            if(!isVis[it])
                dfs(it, stack, adj, isVis);
        stack.push(node);
    }
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        ArrayList<Integer> res=new ArrayList();
        
        HashMap<Integer, ArrayList<Integer>> adj=new HashMap();
        for(int i=0;i<v;i++)
            adj.put(i, new ArrayList());
        
        for(int i=0;i<edges.size();i++)
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        
        boolean[] isVis=new boolean[v+1];
        Stack<Integer> stack=new Stack();
        
        for(int i=0;i<v;i++)
            if(!isVis[i])
                dfs(i, stack, adj, isVis);
        
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        
        return res;
    }
}
