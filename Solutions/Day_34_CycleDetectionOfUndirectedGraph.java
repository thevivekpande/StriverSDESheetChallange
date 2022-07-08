// Using BFS
import java.util.*;

class Pair{
    int first;
    int second;
    Pair(int _first, int _second){
        first=_first;
        second=_second;
    }
}

public class Solution {
    public static boolean isCycle(HashMap<Integer, ArrayList<Integer>> adj, boolean[] isVis, int s){
        Queue<Pair> q=new LinkedList();
        q.offer(new Pair(s,-1));
        isVis[s]=true;
        while(!q.isEmpty()){
            int node=q.peek().first;
            int par=q.peek().second;
            q.poll();
            for(int it:adj.get(node)){
                if(!isVis[it]){
                    isVis[it]=true;
                    q.offer(new Pair(it , node));
                }else if(it!=par) return true;
            }
        }
        return false;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        HashMap<Integer, ArrayList<Integer>> adj=new HashMap();
        for(int i=1;i<=n;i++)
            adj.put(i, new ArrayList());
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] isVis=new boolean[n+1];
        for(int i=1;i<=n;i++)
            if(!isVis[i])
                if(isCycle(adj, isVis, i))
                    return "Yes";
        return "No";
    }
    
}

// Using DFS

import java.util.*;

public class Solution {
    private static boolean isCycle(int node, int par, HashMap<Integer, ArrayList<Integer>> adj, boolean[] isVis){
        isVis[node]=true;
        for(int it : adj.get(node)){
            if(!isVis[it]){
                isVis[it]=true;
                if(isCycle(it, node, adj, isVis))
                    return true;
            }else if(par!=it)
                return true; 
        }
        return false;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        HashMap<Integer, ArrayList<Integer>> adj=new HashMap();
        for(int i=1;i<=n;i++)
            adj.put(i, new ArrayList());
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] isVis=new boolean[n+1];
        
        for(int i=1;i<=n;i++)
            if(!isVis[i])
                if(isCycle(i, -1, adj, isVis))
                    return "Yes";
        return "No";
    }
    
}