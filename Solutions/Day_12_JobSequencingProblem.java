import java.util.*;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
        int n=jobs.length;
        Arrays.sort(jobs, (a,b)->(b[1]-a[1]));
        int maxDeadline=0;
        for(int i=0;i<n;i++)
            maxDeadline=Math.max(maxDeadline, jobs[i][0]);
        boolean[] isVisited=new boolean[maxDeadline+1];
        Arrays.fill(isVisited, false);
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=jobs[i][0];j>0;j--){
                if(!isVisited[j]){
                    isVisited[j]=true;
                    res+=jobs[i][1];
                    break;
                }
            }
        }
        return res;
    }
}
