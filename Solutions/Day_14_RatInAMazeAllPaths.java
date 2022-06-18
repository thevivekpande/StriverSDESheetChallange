import java.util.*;
public class Solution {   
    public static  ArrayList<ArrayList<Integer>> res;
    public static void dfs(int[][] maze, int i, int j, int n, int[][] ans){
        if(i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 || ans[i][j]==1) return;
        
        if(i==n-1 && j==n-1 && maze[i][j]==1){
            ans[i][j]=1;
            res.add(construct(ans));
        }
        
        ans[i][j]=1;
        dfs(maze, i+1, j, n, ans);
        dfs(maze, i-1, j, n, ans);
        dfs(maze, i, j+1, n, ans);
        dfs(maze, i, j-1, n, ans);
        ans[i][j]=0;
    }
    
    public static ArrayList<Integer> construct(int[][] arr){
        ArrayList<Integer> path=new ArrayList();
        for(int[] row: arr)
            for(int i:row)
                path.add(i);
        return path;
    }
    
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        int[][] ans=new int[n][n];
        res=new ArrayList();
        dfs(maze, 0, 0, n, ans);
        return res;
        
    }
}