// A strongly connected component is the portion of a directed graph in which 
// there is a path from each vertex to another vertex. 
// It is applicable only on a directed graph.

// KosaRaju's Algorithms
import java.util.*;
public class Solution {

    public static void dfs(int node, HashMap<Integer, ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] isVis){
        isVis[node]=true;
        for(int it:adj.get(node))
            if(!isVis[it])
                dfs(it, adj, stack, isVis);
        stack.push(node);
    }
    
    public static void revDfs(int node, HashMap<Integer, ArrayList<Integer>> transpose, List<Integer> scc, boolean[] isVis){
        isVis[node]=true;
        scc.add(node);
        for(int it:transpose.get(node))
            if(!isVis[it])
                revDfs(it, transpose, scc, isVis);
    }
    
    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        HashMap<Integer, ArrayList<Integer>> adj=new HashMap();
        for(int i=0;i<n;i++)
            adj.put(i, new ArrayList());
        
        for(int i=0;i<edges.length;i++)
            adj.get(edges[i][0]).add(edges[i][1]);
        
        boolean[] isVis=new boolean[n];
        Stack<Integer> stack=new Stack();
        for(int i=0;i<n;i++){
            if(!isVis[i])
                dfs(i, adj, stack, isVis);
        }
        
        HashMap<Integer, ArrayList<Integer>> transpose=new HashMap<>();
        
        for(int i=0;i<n;i++)
            transpose.put(i, new ArrayList());
        
        for(int i=0;i<n;i++){
            isVis[i]=false;
            for(int it:adj.get(i))
                transpose.get(it).add(i);
        }
        
        List<List<Integer>> res=new ArrayList();
        while(!stack.isEmpty()){
            int node=stack.pop();
            if(!isVis[node]){
                List<Integer> scc=new ArrayList();
                revDfs(node, transpose, scc, isVis);
                res.add(scc);
            }
        }
        
        return res;
    }
}
