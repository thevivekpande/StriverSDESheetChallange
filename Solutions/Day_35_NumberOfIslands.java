public class Solution 
{
    public static void dfs(int[][] mat, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || mat[i][j]==0) return;
        
            mat[i][j]=0;
            dfs(mat, i+1, j, m, n);
            dfs(mat, i, j+1, m, n);
            dfs(mat, i-1, j, m, n);
            dfs(mat, i, j-1, m, n);
            dfs(mat, i+1, j+1, m, n);
            dfs(mat, i+1, j-1, m, n);
            dfs(mat, i-1, j+1, m, n);
            dfs(mat, i-1, j-1, m, n);
        
    }
    public static int getTotalIslands(int[][] mat) 
	{
        //Your code goes here
        int count=0;
        int m=mat.length, n=mat[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    dfs(mat, i, j, m, n);
                    count++;
                }
            }
        }
        
        return count;
    }
}