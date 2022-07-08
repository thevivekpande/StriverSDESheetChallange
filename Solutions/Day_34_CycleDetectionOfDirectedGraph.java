import java.util.*;
public class Solution {
    
  public static boolean isCycle(int node, boolean[] dfsVis, HashMap<Integer, ArrayList<Integer>> adj, boolean[] isVis){
      isVis[node]=true;
      dfsVis[node]=true;
      for(int it:adj.get(node))
          if(!isVis[it]){
              if(isCycle(it, dfsVis, adj, isVis))
                  return true;
          }else if(dfsVis[it]) 
              return true;
      dfsVis[node]=false;
      return false;
  } 
    
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
      HashMap<Integer, ArrayList<Integer>> adj=new HashMap();
      
      for(int i=1;i<=n;i++)
          adj.put(i, new ArrayList());
      
      for(int i=0;i<edges.size();i++)
          adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
      
      boolean[] isVis=new boolean[n+1];
      boolean[] dfsVis=new boolean[n+1];
      for(int i=1;i<=n;i++)
          if(!isVis[i])
              if(isCycle(i, dfsVis, adj, isVis))
                  return true;
      
      return false;
  }
}