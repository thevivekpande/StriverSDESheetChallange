// Using BFS
import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        int[] inDegree=new int[v];
        
        HashMap<Integer, ArrayList<Integer>> adj=new HashMap();
        for(int i=0;i<v;i++)
            adj.put(i, new ArrayList());
        
        for(int i=0;i<edges.size();i++)
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        
        for(int i=0;i<v;i++)
            for(int it:adj.get(i))
                inDegree[it]++;
        
        Queue<Integer> q=new LinkedList();
        ArrayList<Integer> res=new ArrayList();
        
        for(int i=0;i<v;i++)
            if(inDegree[i]==0)
                q.offer(i);
        
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int it: adj.get(node))
            {
                if(--inDegree[it]==0)
                    q.offer(it);
            }
        }
        
        return res;
    }
}


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