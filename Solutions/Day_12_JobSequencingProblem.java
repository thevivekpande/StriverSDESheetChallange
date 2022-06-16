import java.util.*;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
        int n=jobs.length;
        Arrays.sort(jobs, (a,b)->(b[1]-a[1]));
        int maxDeadline=jobs[0][0];
        for(int i=0;i<n;i++)
            maxDeadline=Math.max(jobs[i][0], maxDeadline);
        int result[]=new int[maxDeadline+1];
        Arrays.fill(result, -1);
        int jobProfits=0;
        for(int i=0;i<n;i++){
            for(int j=jobs[i][0];j>0;j--){
                if(result[j]==-1){
                    result[j]=i;
                    jobProfits+=jobs[i][1];
                    break;
                }
            }
        }
        return jobProfits;
    }
}
