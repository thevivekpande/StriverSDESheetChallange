import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        HashMap<Integer, ArrayList<Integer>> map=new HashMap();
        
        for(int i=0; i<v; i++)
            map.put(i, new ArrayList());
        
        for(int i=0;i<edges.size();i++){
            map.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            map.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        boolean[] isVis=new boolean[v+1];
        
        for(int i=0;i<v;i++){
            if(!isVis[i]){
                ArrayList<Integer> dfsTraversal = new ArrayList();
                dfs(i, dfsTraversal, isVis, map);
                if(dfsTraversal.size()==0) continue;
                res.add(dfsTraversal);
            }
        }
        
        return res;
    }
    
    public static void dfs(int node, ArrayList<Integer> dfsTraversal, boolean[] isVis, HashMap<Integer, ArrayList<Integer>> edges){
        isVis[node]=true;
        dfsTraversal.add(node);
        for(Integer it : edges.get(node)){
            if(!isVis[it])
                dfs(it, dfsTraversal, isVis, edges);
        }
    }
}