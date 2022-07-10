
import java.util.*;

class Pair{
    Integer key;
    Integer value;
    Pair(Integer key,Integer value){
        this.key=key;
        this.value=value;
    }
}
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Write your code here.
        HashMap<Integer, ArrayList<Pair>> adj=new HashMap();
        for(int i=1;i<=n;i++)
            adj.put(i, new ArrayList());
        for(int i=0;i<g.size();i++){
            int u=g.get(i).get(0);
            int v=g.get(i).get(1);
            int w=g.get(i).get(2);
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        int[] key=new int[n+1];
        boolean[] mst=new boolean[n+1];
        int[] parent=new int[n+1];
        
        for(int i=0;i<=n;i++){
            key[i]=Integer.MAX_VALUE;
            parent[i]=-1;
            mst[i]=false;
        }
        
        key[1]=0;
        
        for(int i=1;i<n;i++){
            int mini=Integer.MAX_VALUE;
            int u=0;
            for(int v=1;v<=n;v++){
                if(!mst[v] && key[v]<mini){
                    u=v;
                    mini=key[v];
                }
            }
            mst[u]=true;
            for(Pair it : adj.get(u)){
                int v=it.key;
                int w=it.value;
                if(!mst[v] && w<key[v]){
                    parent[v]=u;
                    key[v]=w;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        for(int i=2;i<=n;i++){
            ArrayList<Integer> temp=new ArrayList();
            temp.add(parent[i]);
            temp.add(i);
            temp.add(key[i]);
            res.add(temp);
        }
        
        return res;
    }
}
