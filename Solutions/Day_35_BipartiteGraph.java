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
