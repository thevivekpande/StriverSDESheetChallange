import java.util.*;
public class Solution {
    public static void bfs(ArrayList<Integer> res, int node, HashMap<Integer, ArrayList<Integer>> adj, boolean[] isVis){
        Queue<Integer> q=new LinkedList();
        q.offer(node);
        isVis[node]=true;
        
        while(!q.isEmpty()){
            int cur=q.poll();
            res.add(cur);
            for(Integer i : adj.get(cur)){
                if(!isVis[i]){
                    isVis[i]=true;
                    q.offer(i);
                }
            }
        }
    }
	public static ArrayList<Integer> BFS(int vertex, int edges[][]){
		// WRITE YOUR CODE HERE
        ArrayList<Integer> res=new ArrayList();
        HashMap<Integer, ArrayList<Integer>> adj=new HashMap();
        
        for(int i=0;i<vertex;i++)
            adj.put(i, new ArrayList());
        
        for(int i=0; i<edges[0].length; i++){
            adj.get(edges[0][i]).add(edges[1][i]);
            adj.get(edges[1][i]).add(edges[0][i]);
        }
        
        boolean[] isVis=new boolean[vertex+1];
        
        for(int i=0;i<vertex;i++)
            Collections.sort(adj.get(i));
        
        for(int i=0;i<vertex;i++){
            if(!isVis[i]){
                bfs(res, i, adj, isVis);
            }
        }
        return res;
	}
}

