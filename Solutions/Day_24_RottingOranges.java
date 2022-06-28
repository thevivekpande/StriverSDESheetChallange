import java.util.*;
public class Solution {
	public static int minTimeToRot(int[][] grid, int n, int m) {
		// Write your code here.
        Queue<int[]> q=new LinkedList<>();
        int totalOranges=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i, j});
                if(grid[i][j]!=0)
                    totalOranges++;
            }
        }
        
        int count=0, res=0;
        int[] dx=new int[]{1, -1, 0, 0};
        int[] dy=new int[]{0, 0, 1, -1};
        
        while(!q.isEmpty()){
            int size=q.size();
            count+=size;
            for(int i=0;i<size;i++){
                int[] temp=q.poll();
                for(int j=0;j<4;j++){
                    int x=temp[0]+dx[j];
                    int y=temp[1]+dy[j];
                    
                    if(x<0 || y<0 || x>=n || y>=m || grid[x][y]==0 || grid[x][y]==2) continue;
                    grid[x][y]=2;
                    q.offer(new int[]{x, y});
                }
            }
            if(q.size()!=0)
                res++;
        }
        
        return totalOranges==count?res:-1;
	}

}