import java.util.*;

public class Solution {
    static int inf=(int)1e9;
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int dist[][] = new int[n+1][n+1];
        ArrayList<ArrayList<Integer>> adj=new ArrayList();
      
      for(int i=0;i<=n;i++){
          adj.add(new ArrayList());
          for(int j=0;j<=n;j++)
              adj.get(i).add(inf);
      }
      
      for(ArrayList<Integer> edge : edges){
          adj.get(edge.get(0)).set(edge.get(1), edge.get(2));
      }
      
      int n1=n+1;
      while(n1-->0){
          adj.get(n1).set(n1, 0);
      }
      
        for (int k =1 ; k <= n; k++)
        {
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if((adj.get(i).get(k)!=1e9 && adj.get(k).get(j)!=1e9) && (adj.get(i).get(k)+adj.get(k).get(j)<adj.get(i).get(j))){
                    adj.get(i).set(j, adj.get(i).get(k)+adj.get(k).get(j));
                }
                }
            }
        }
      
      return adj.get(src).get(dest);
  }

}
