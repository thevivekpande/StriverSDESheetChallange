import java.util.*;
class Node implements Comparator<Node>{
    int u;
    int v;
    int w;
    Node(){};
    Node(int _u, int _v, int _w){
        u=_u;
        v=_v;
        w=_w;
    }
    public int compare(Node n1, Node n2){
        return n1.w-n2.w;
    }
}
public class Solution {
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        // Write your code here.
        ArrayList<Node> arr=new ArrayList();
        for(int i=0;i<m;i++)
            arr.add(new Node(graph.get(i).get(0), graph.get(i).get(1), graph.get(i).get(2)));
        Collections.sort(arr, new Node());
        int[] parent=new int[n+1];
        int[] rank=new int[n+1];
        int c=0, res=0;
        for(int i=0;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(Node it:arr){
            int u=findParent(it.u, parent);
            int v=findParent(it.v, parent);
            if(u!=v){
                union(u, v, parent, rank);
                res+=it.w;
                c++;
                if(c==n-1) break;
            }
        }
        return res;
    }
    
    public static void union(int u, int v, int[] parent, int[] rank){
        if(rank[u]>rank[v])
            parent[v]=parent[u];
        else if(u<v)
            parent[u]=parent[v];
        else{
            parent[v]=parent[u];
            rank[u]++;
        }
    }
    
    public static int findParent(int node, int[] parent){
        if(node==parent[node])
            return node;
        return parent[node]=findParent(parent[node], parent);
    }
}