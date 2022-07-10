import java.util.*;
public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[] dist=new int[n+1];
        Arrays.fill(dist, 1000000000);
        dist[src]=0;
        for(int i=0;i<n-1;i++){
            for(ArrayList<Integer> edge : edges){
                int u=edge.get(0);
                int v=edge.get(1);
                int wt=edge.get(2);
                int weight=dist[u]==1000000000?1000000000 : wt + dist[u];
                dist[v] = Math.min(dist[v], weight);
            }
        }
        return dist[dest];
    }
}
