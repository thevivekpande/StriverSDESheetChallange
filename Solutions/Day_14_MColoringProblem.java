import java.util.*;
public class Solution {
    static int V;
    public static boolean isSafe(int[][] mat, int[] color, int c, int v){
        for(int i=0;i<V;i++)
            if(mat[v][i]==1 && color[i]==c)
                return false;
        return true;
    }
    public static boolean graphColorUtil(int v, int m, int[][] mat, int[] color){
        if(v==V)
            return true;
        for(int c=1;c<=m;c++){
            if(isSafe(mat, color, c, v)){
                color[v]=c;
                if(graphColorUtil(v+1, m, mat, color))
                    return true;
                color[v]=0;
            }
        }
        return false;
    }
	public static String graphColoring(int[][] mat, int m) {
		// Write your code here
        V=mat.length;
        int[] color=new int[V];
        if(graphColorUtil(0, m, mat, color))
            return "YES";
        return "NO";
	}
}
