// Using DFS
import java.util.*;

public class Solution {

    public static boolean dfs(int node, HashMap<Integer, ArrayList<Integer>> adj, int[] color){
        if(color[node]==-1) color[node]=1;
        for(int it:adj.get(node)){
            if(color[it]==-1){
                color[it]=1-color[node];
                if(!dfs(it, adj, color)) return false;
            }else if(color[it]==(color[node]))
                return false;
        }
        return true;
    }
    
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        // Write your code here
        HashMap<Integer, ArrayList<Integer>> adj=new HashMap();
        for(int i=0;i<edges.size();i++)
            adj.put(i, new ArrayList());
        
        for(int i=0;i<edges.size();i++){
            for(int j=0;j<edges.size();j++){
                if(edges.get(i).get(j)==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int[] color=new int[edges.size()];
        Arrays.fill(color, -1);
        
        for(int i=0;i<edges.size();i++){
            if(color[i]==-1)
                if(!dfs(i, adj, color))
                    return false;
        }
        
        return true;
    }
}
